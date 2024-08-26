
package ec.espe.edu.rolepaymentsystem.controller;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Code Master
 */
public interface IEmployeeStorage {
    Reader getReader(String filePath) throws IOException;
    Writer getWriter(String filePath) throws IOException;
}

