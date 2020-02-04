/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2020 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.scalar;

import org.cactoos.Scalar;

/**
 * Float Scalar which sums up the values of other Scalars of the same type
 *
 * <p>Here is how you can use it to summarize float numbers:</p>
 *
 * <pre>{@code
 * float sum = new SumOfFloatScalar(() -> 1f,() -> 2f, () -> 3f).value();
 * }</pre>
 *
 * <p>This class implements {@link Scalar}, which throws a checked
 * {@link Exception}. Despite that this class does NOT throw a checked
 * exception.</p>
 *
 * <p>There is no thread-safety guarantee.
 *
 * @since 0.30
 */
public final class SumOfFloat implements Scalar<Float> {

    /**
     * Varargs of Scalar to sum up values from.
     */
    private final Scalar<Float>[] scalars;

    /**
     * Ctor.
     * @param src Varargs of Scalar to sum up values from
     * @since 0.30
     */
    @SafeVarargs
    public SumOfFloat(final Scalar<Float>... src) {
        this.scalars = src;
    }

    @Override
    public Float value() {
        return new SumOfScalar(this.scalars).value().floatValue();
    }
}
