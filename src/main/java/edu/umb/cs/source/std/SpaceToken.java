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

import edu.umb.cs.source.SourceToken;
import edu.umb.cs.source.SourceTokenKind;

/**
 *
 * @author Vy Thao Nguyen
 */
public class SpaceToken implements SourceToken
{

    public static final SpaceToken INSTANCE = new SpaceToken();

    private SpaceToken() {}

    @Override
    public String image()
    {
        return " ";
    }

    @Override
    public SourceTokenKind getKind()
    {
        return SourceTokenKind.SPACE;
    }
}
