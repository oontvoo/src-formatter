/**
 * Copyright (C) 2013 Vy Thao Nguyen
 *
 * This program allows you to format your java source file.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package edu.umb.cs.source;

import edu.umb.cs.parser.BracingStyle;
import edu.umb.cs.parser.Language;
import edu.umb.cs.parser.InternalException;
import edu.umb.cs.parser.JavaParser;
import edu.umb.cs.parser.ParseException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Vy Thao Nguyen
 */
public class Formatter 
{
    public static SourceFile parseFile(File file,
                                       Language languageType,
                                       BracingStyle style)
                             throws FileNotFoundException, ParseException
    {
        switch(languageType)
        {
            case JAVA:
                JavaParser parser = new JavaParser(new FileInputStream(file));
                return parser.parseJava(style);
            default:
                throw new InternalException("Unsupported Language: " + languageType);
        }
    }
}
