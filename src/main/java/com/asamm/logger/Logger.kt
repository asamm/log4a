/****************************************************************************
 *
 * Created by menion on 14.04.2021.
 * Copyright (c) 2021. All rights reserved.
 *
 * This file is part of the Asamm team software.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 *
 ***************************************************************************/
package com.asamm.logger

import java.util.regex.Pattern

/**
 * Generic static logger instance used in Asamm libraries.
 *
 * To receive correct log messages, initialize over `registerLogger` as soon as possible.
 *
 * In all cases, calls may contain optional array of arguments for easier message formating. Good practice is
 * to use system supported by the [String.format] method.
 */
@Suppress("unused")
object Logger {

    // VERBOSE

    /**
     * Log 'verbose' [msg].
     *
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun v(msg: String, vararg args: Any) {
        v(generateTag(), msg, *args)
    }

    /**
     * Log 'verbose' [msg].
     *
     * @param tag tag that identify source class
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun v(tag: String, msg: String, vararg args: Any) {
        printBasic(logger, ILogger::logV, tag, msg, *args)
    }

    // INFORMATION

    /**
     * Log 'informative' [msg].
     *
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun i(msg: String, vararg args: Any) {
        i(generateTag(), msg, args)
    }

    /**
     * Log 'informative' [msg].
     *
     * @param tag tag that identify source class
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun i(tag: String, msg: String, vararg args: Any) {
        printBasic(logger, ILogger::logI, tag, msg, *args)
    }

    // DEBUG

    /**
     * Log 'debug' [msg].
     *
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun d(msg: String, vararg args: Any) {
        d(generateTag(), msg, args)
    }

    /**
     * Log 'debug' [msg].
     *
     * @param tag tag that identify source class
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun d(tag: String, msg: String, vararg args: Any) {
        printBasic(logger, ILogger::logD, tag, msg, *args)
    }

    // WARNING

    /**
     * Log 'warning' [msg].
     *
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun w(msg: String, vararg args: Any) {
        w(generateTag(), msg, args)
    }

    /**
     * Log 'warning' [msg].
     *
     * @param tag tag that identify source class
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun w(tag: String, msg: String, vararg args: Any) {
        w(null, tag, msg, *args)
    }

    /**
     * Log 'warning' [msg].
     *
     * @param ex (optional) caught exception
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun w(ex: Throwable? = null, msg: String, vararg args: Any) {
        w(ex, generateTag(), msg, args)
    }

    /**
     * Log 'warning' [msg].
     *
     * @param ex (optional) caught exception
     * @param tag tag that identify source class
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    fun w(ex: Throwable? = null, tag: String, msg: String, vararg args: Any) {
        printEx(logger, ILogger::logW, ex, tag, msg, args)
    }

    // ERROR

    /**
     * Log 'error' [msg].
     *
     * @param ex (optional) caught exception
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    @JvmOverloads
    fun e(ex: Throwable? = null, msg: String, vararg args: Any) {
        e(ex, generateTag(), msg, args)
    }

    /**
     * Log 'error' [msg].
     *
     * @param ex (optional) caught exception
     * @param tag tag that identify source class
     * @param msg log text message, optionally with arguments
     * @param args optional arguments that should be logged in the implementation with 'String.format' call.
     */
    @JvmStatic
    @JvmOverloads
    fun e(ex: Throwable? = null, tag: String, msg: String, vararg args: Any) {
        printEx(logger, ILogger::logE, ex, tag, msg, args)
    }

    //*************************************************
    // LOGGER INTERFACE
    //*************************************************

    // reference to logger implementation
    private var logger: ILogger? = null

    /**
     * Register [logger] implementation.
     */
    fun registerLogger(logger: ILogger) {
        Logger.logger = logger
    }

    /**
     * Custom logger implementation.
     */
    interface ILogger {

        /**
         * Log 'verbose' [msg].
         *
         * @param tag tag that identify source class
         * @param msg log text message, optionally with arguments
         * @param args optional arguments that should be logged in the implementation with 'String.format' call.
         */
        fun logV(tag: String, msg: String, vararg args: Any)

        /**
         * Log 'informative' [msg].
         *
         * @param tag tag that identify source class
         * @param msg log text message, optionally with arguments
         * @param args optional arguments that should be logged in the implementation with 'String.format' call.
         */
        fun logI(tag: String, msg: String, vararg args: Any)

        /**
         * Log 'debug' [msg].
         *
         * @param tag tag that identify source class
         * @param msg log text message, optionally with arguments
         * @param args optional arguments that should be logged in the implementation with 'String.format' call.
         */
        fun logD(tag: String, msg: String, vararg args: Any)

        /**
         * Log 'warning' [msg].
         *
         * @param ex (optional) caught exception
         * @param tag tag that identify source class
         * @param msg log text message, optionally with arguments
         * @param args optional arguments that should be logged in the implementation with 'String.format' call.
         */
        fun logW(ex: Throwable? = null, tag: String, msg: String, vararg args: Any)

        /**
         * Log 'error' [msg].
         *
         * @param ex (optional) caught exception
         * @param tag tag that identify source class
         * @param msg log text message, optionally with arguments
         * @param args optional arguments that should be logged in the implementation with 'String.format' call.
         */
        fun logE(ex: Throwable? = null, tag: String, msg: String, vararg args: Any)
    }

    //*************************************************
    // TAG GENERATOR
    //*************************************************

    // max tag length
    private const val MAX_TAG_LENGTH = 23

    // index where should be stack class info
    private const val CALL_STACK_INDEX = 2

    // anonymous class detection
    private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")

    /**
     * Extract the tag which should be used for the message from the `element`. By default
     * this will use the class name without any anonymous class suffixes (e.g., `Foo$1`
     * becomes `Foo`).
     *
     * Note: This will not be called if a [manual tag][.tag] was specified.
     *
     * @param extraDepthIndex extra index of stack
     */
    private fun generateTag(extraDepthIndex: Int = 1): String {
        val stackTrace = Throwable().stackTrace
        if (stackTrace.size <= CALL_STACK_INDEX + extraDepthIndex) {
            // "Synthetic stacktrace didn't have enough elements: are you using proguard?"
            return "Unknown"
        }

        // extract tag
        var tag = stackTrace[CALL_STACK_INDEX + extraDepthIndex].className
        val m = ANONYMOUS_CLASS.matcher(tag)
        if (m.find()) {
            tag = m.replaceAll("")
        }
        tag = tag.substring(tag.lastIndexOf('.') + 1)

        // return limited tag
        return if (tag.length <= MAX_TAG_LENGTH) {
            tag
        } else {
            tag.substring(0, MAX_TAG_LENGTH)
        }
    }

    //*************************************************
    // PRIVATE TOOLS
    //*************************************************

    private fun printBasic(logger: ILogger?,
            logCall: ILogger.(String, String, Any) -> Unit,
            tag: String, msg: String, vararg args: Any) {
        try {
            logger?.logCall(tag, msg, args)
                    ?: printSystemDefault(tag, msg, *args)
        } catch (e: Exception) {
            printSystemSafe(tag, msg, e)
        }
    }

    private fun printEx(logger: ILogger?,
            logCall: ILogger.(Throwable?, String, String, Any) -> Unit,
            ex: Throwable? = null, tag: String, msg: String, vararg args: Any) {
        try {
            logger?.logCall(ex, tag, msg, args)
                    ?: printSystemDefault(tag, msg, *args)
        } catch (e: Exception) {
            printSystemSafe(tag, msg, e)
        }
    }

    private fun printSystemDefault(tag: String, msg: String, vararg args: Any, ex: Exception? = null) {
        if (ex == null) {
            println("$tag, ${msg.format(*args)}")
        } else {
            System.err.println("$tag, ${msg.format(*args)}, ex:" + ex.message)
        }
        ex?.printStackTrace()
    }

    private fun printSystemSafe(tag: String, msg: String, ex: Exception? = null) {
        println("$tag, $msg")
        ex?.printStackTrace()
    }
}
