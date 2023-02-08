/*
 * Created by menion on 10.10.21 12:48.
 * Copyright (c) 2021. All rights reserved.
 *
 * This file is part of the Asamm team software.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 */

package com.asamm.loggerV2

/**
 * An enum for log priorities.
 */
enum class LogPriority(val priority: Int) {

    /**
     * Verbose priority.
     */
    VERBOSE(2),

    /**
     * Debug priority.
     * Optimal base minimal priority value for debug builds.
     */
    DEBUG(3),

    /**
     * Info priority.
     */
    INFO(4),

    /**
     * Warning priority.
     * Optimal base minimal priority value for release builds.
     */
    WARN(5),

    /**
     * Error priority.
     */
    ERROR(6),
}
