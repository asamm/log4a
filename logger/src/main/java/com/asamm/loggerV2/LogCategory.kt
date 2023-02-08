/*
 * Created by menion on 9.10.21 6:55.
 * Copyright (c) 2021. All rights reserved.
 *
 * This file is part of the Asamm team software.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 */

package com.asamm.loggerV2

/**
 * Category for log messages.
 *
 * @param tagPrefix prefix for the tag that allows to easily find logs from single category
 * @param minPriority minimal defined priority of log messages.
 * @param public flag that define if category may be modified by the user
 */
data class LogCategory(
    val tagPrefix: String,
    var minPriority: LogPriority = LogPriority.WARN,
    val public: Boolean = false,
    val title: CharSequence,
    val desc: CharSequence,
) {

    companion object {

        val CORE = LogCategory(
            tagPrefix = "",
            minPriority = LogPriority.VERBOSE,
            title = "Core",
            desc = "Core/not specified logs"
        )
    }
}
