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
import edu.umb.cs.source.SourceFile;
import edu.umb.cs.source.SourceToken;
import java.util.List;
import java.util.Map;

/**
 * Simple representation of a Java Source File
 * @author Vy Thao Nguyen
 */
public class JavaSourceFile implements SourceFile
{

    private final String path;
    private final List<List<SourceToken>> srcFile;
    private final int tokenCount;
    private final Map<SourceToken, Integer> stats;
    private final BracingStyle style;
    
    public JavaSourceFile(String path,
                          List<List<SourceToken>> tokens,
                          int tokenCount,
                          BracingStyle style)
    {
        this.path = path;
        this.srcFile = tokens;
        this.tokenCount = tokenCount;
        this.style = style;
        stats = buildStats(srcFile);
    }
    
    // Object interface
    
    @Override
    public String toString()
    {
        StringBuilder bd = new StringBuilder();
        for (List<SourceToken> line : srcFile)
        {
            for (SourceToken tk : line)
            {
                bd.append(tk.image());
            }
            bd.append('\n');
        }
        
        return bd.toString();
    }
    
    // SourceFile interface
    
    @Override
    public BracingStyle getStyle()
    {
        return style;
    }

    @Override
    public List<SourceToken> getTokens(int line)
    {
        return srcFile.get(line);
    }

    @Override
    public SourceToken getToken(int line, int position)
    {
        return srcFile.get(line).get(position);
    }

    @Override
    public int tokenCount(int line)
    {
        return srcFile.get(line).size();
    }

    @Override
    public int tokenCount()
    {
        return tokenCount;
    }

    @Override
    public int lineCount()
    {
        return srcFile.size();
    }

    @Override
    public Map<SourceToken, Integer> getStatistic()
    {
        return stats;
    }

    @Override
    public String compileAndExecute()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static Map<SourceToken, Integer> buildStats(List<List<SourceToken>> srcFile)
    {
        return null;
        //throw new UnsupportedOperationException();
    }
}
