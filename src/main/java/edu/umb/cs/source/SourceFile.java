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
import java.util.List;
import java.util.Map;

/**
 * This represents a source file
 * 
 * @author Vy Thao Nguyen
 */
public interface SourceFile
{
    BracingStyle getStyle();
    
    List<SourceToken> getTokens(int line);
    
    /**
     * 
     * @param line
     * @param position
     * @return the token at the given line and position
     */
    SourceToken getToken(int line, int position);
    
    /**
     * 
     * @param line (First line is 0)
     * @return number of non-distinct tokens in the give line
     */
    int tokenCount(int line);

    /**
     * 
     * @return number of non-distinct tokens in the source
     */
    int tokenCount();
    
    /**
     * @return number of lines in the source
     */
    int lineCount();
    
    /**
     * Each entry == [SourceToken --> Number of occurrences ]
     * @return a SourceToken-to-Occurrences mapping
     */
    Map<SourceToken, Integer> getStatistic();
    
    /**
     * compile the source, execute and return the output
     */
    String compileAndExecute();
}
