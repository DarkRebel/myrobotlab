/*
 * DynamicJava - Copyright (C) 1999 Dyade
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files
 * (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL DYADE BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 * Except as contained in this notice, the name of Dyade shall not be
 * used in advertising or otherwise to promote the sale, use or other
 * dealings in this Software without prior written authorization from
 * Dyade.
 *
 */

package org.myrobotlab.java;


import java.lang.reflect.Constructor;

/**
 * The instances of this class provides informations about
 * class constructors compiled to JVM bytecode.
 *
 * @author  Stephane Hillion
 * @version 1.0 - 1999/06/03
 */

public class JavaConstructorInfo implements ConstructorInfo {
    /**
     * The underlying constructor
     */
    private Constructor javaConstructor;

    /**
     * Creates a new class info
     * @param f the java constructor
     */
    public JavaConstructorInfo(Constructor f) {
        javaConstructor = f;
    }

    /**
     * Returns the modifiers for the constructor represented by this object
     */
    public int getModifiers() {
        return javaConstructor.getModifiers();
    }

    /**
     * Returns an array of class infos that represent the parameter
     * types, in declaration order, of the constructor represented
     * by this object
     */
    public ClassInfo[] getParameterTypes() {
        Class[]     pcs    = javaConstructor.getParameterTypes();
        ClassInfo[] result = new ClassInfo[pcs.length];

        for (int i = 0; i < pcs.length; i++) {
            result[i] = new JavaClassInfo(pcs[i]);
        }
        return result;
    }

    /**
     * Returns an array of Class infos that represent the types of
     * the exceptions declared to be thrown by the underlying constructor
     */
    public ClassInfo[] getExceptionTypes() {
        Class[]     ecs    = javaConstructor.getExceptionTypes();
        ClassInfo[] result = new ClassInfo[ecs.length];

        for (int i = 0; i < ecs.length; i++) {
            result[i] = new JavaClassInfo(ecs[i]);
        }
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof JavaConstructorInfo)) {
            return false;
        }
        return javaConstructor.equals(((JavaConstructorInfo)obj).javaConstructor);
    }
}
