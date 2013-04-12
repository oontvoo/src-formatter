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

import edu.umb.cs.parser.BracingStyle;
import edu.umb.cs.parser.ParseException;
import edu.umb.cs.parser.Language;
import edu.umb.cs.source.SourceFile;
import edu.umb.cs.source.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Vy Thao Nguyen
 */
public class Main
{
    private static final String USAGE
        = "Usage: java -jar src-formatter.jar <path to file> [<output file> [<ALLMAN> | <K&R>]]";

    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        if (args == null || args.length != 1 && args.length != 2 && args.length != 3)
            System.out.println(USAGE);
        else
        {
            BracingStyle style = BracingStyle.ALLMAN;
            PrintStream stdout = System.out;

            switch(args.length)
            {
                case 3:
                    style = args[2].equalsIgnoreCase("allman")
                                ? BracingStyle.ALLMAN
                                : BracingStyle.K_AND_R;
                    // fall through
                case 2:
                    System.setOut(new PrintStream(args[1]));
                    break;
            }

            SourceFile src = Formatter.parseFile(new File(args[0]),
                                                 Language.JAVA,
                                                 style);
            System.out.println(src.toString());
            // reset to standard output
            System.setOut(stdout);
        }
    }
}
