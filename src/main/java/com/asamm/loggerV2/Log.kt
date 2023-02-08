/*
 * Created by menion on 10.10.21 13:21.
 * Copyright (c) 2021. All rights reserved.
 *
 * This file is part of the Asamm team software.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 */

package com.asamm.loggerV2

import com.asamm.logger.Logger


/**
 * "VERBOSE" log message.
 */
inline fun logV(
    category: LogCategory = LogCategory.CORE,
    tag: String? = null,
    msg: () -> String
) {
    if (category.minPriority.priority <= LogPriority.VERBOSE.priority) {
        Logger.v(
            tag = Log.getValidTag(category, tag),
            msg = msg()
        )
    }
}

/**
 * "DEBUG" log message.
 */
inline fun logD(
    category: LogCategory = LogCategory.CORE,
    tag: String? = null,
    ex: Throwable? = null,
    msg: () -> String
) {
    if (category.minPriority.priority <= LogPriority.DEBUG.priority) {
        Logger.d(
            tag = Log.getValidTag(category, tag),
            msg = msg(),
            ex = ex
        )
    }
}

/**
 * "INFO" log message.
 */
inline fun logI(
    category: LogCategory = LogCategory.CORE,
    tag: String? = null,
    msg: () -> String
) {
    if (category.minPriority.priority <= LogPriority.INFO.priority) {
        Logger.i(
            tag = Log.getValidTag(category, tag),
            msg = msg()
        )
    }
}

/**
 * "WARNING" log message.
 */
inline fun logW(
    category: LogCategory = LogCategory.CORE,
    tag: String? = null,
    ex: Throwable? = null,
    msg: () -> String
) {
    if (category.minPriority.priority <= LogPriority.WARN.priority) {
        Logger.w(
            tag = Log.getValidTag(category, tag),
            msg = msg(),
            ex = ex
        )
    }
}

/**
 * "ERROR" log message.
 */
inline fun logE(
    category: LogCategory = LogCategory.CORE,
    tag: String? = null,
    ex: Throwable? = null,
    msg: () -> String
) {
    if (category.minPriority.priority <= LogPriority.ERROR.priority) {
        Logger.e(
            tag = Log.getValidTag(category, tag),
            msg = msg(),
            ex = ex
        )
    }
}

object Log {

    fun getValidTag(category: LogCategory, tag: String?) =
        "${category.tagPrefix}${tag ?: Logger.generateTag(0)}"
}
