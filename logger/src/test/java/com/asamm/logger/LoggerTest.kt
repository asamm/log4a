/****************************************************************************
 *
 * Created by menion on 04.02.2021.
 * Copyright (c) 2021. All rights reserved.
 *
 * This file is part of the Asamm team software.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 *
 ***************************************************************************/
package com.asamm.logger

import org.junit.Test

internal class LoggerTest {

    @Test
    fun v() {
        Logger.v("Test Asamm message")
        Logger.v(msg = "Test %s message", "Asamm")
    }
}