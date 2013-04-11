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
package edu.umb.cs;

import edu.umb.cs.parser.ParseException;
import edu.umb.cs.source.Language;
import edu.umb.cs.source.SourceFile;
import edu.umb.cs.source.SourceFiles;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Vy Thao Nguyen
 */
public class Main
{
    private static final String USAGE = "Usage: java -jar src-main <path to file>";
    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        if (args == null || args.length != 1)
            System.out.println(USAGE);
        
        else
        {
            SourceFile src = SourceFiles.getSourceFile(new File(args[0]),
                                                       Language.JAVA);
            System.out.println(src.toString());
        }
    }
}
