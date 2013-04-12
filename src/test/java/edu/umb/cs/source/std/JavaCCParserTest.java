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

package edu.umb.cs.source.std;

import edu.umb.cs.parser.BracingStyle;
import edu.umb.cs.parser.JavaParser;
import edu.umb.cs.parser.ParseException;
import edu.umb.cs.source.SourceFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Vy Thao Nguyen
 */
public class JavaCCParserTest extends SourceTestBase
{
    private static final File TESTS_PATH = new File("src/test/resources/sources/javaccparse");
    
    @Override
    void doTest(File expted, File in) throws FileNotFoundException, IOException
    {
        FileInputStream fin1 = null;
        FileInputStream fin2 = null;
        JavaParser parser;
        try
        {
            // K%R style
            fin1 = new FileInputStream(in);
            parser = new JavaParser(fin1);
            System.out.println("K&R style:");
            SourceFile kAndR = parser.parseJava(BracingStyle.K_AND_R);
            System.out.println(kAndR);   
            
            // Allman style
            fin2 = new FileInputStream(in);
            System.out.println("\n-----------\nAllman style:");
            parser.ReInit(fin2);
            SourceFile allman = parser.parseJava(BracingStyle.ALLMAN);
            System.out.println(allman);   
            
        }
        catch (ParseException ex)
        {
            throw new RuntimeException(ex);
        }
        finally
        {
            if (fin1 != null)
                fin1.close();
            if (fin2 != null)
                fin2.close();
        }
    }

    @Override
    File getPath()
    {
        return TESTS_PATH;
    }
}
