class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private final SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat[] inputFormats = {
        new SimpleDateFormat("dd/MM/yyyy"),
        new SimpleDateFormat("MMM d, yyyy", Locale.US)
    };

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(outputFormat.format(src));
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String dateStr = json.getAsString();
        return Arrays.stream(inputFormats)
            .map(format -> {
                try {
                    return format.parse(dateStr);
                } catch (ParseException e) {
                    return null;
                }
            })
            .filter(Objects::nonNull)
            .findFirst()
            .orElseThrow(() -> new JsonParseException("Unparseable date: \"" + dateStr + "\""));
    }
}