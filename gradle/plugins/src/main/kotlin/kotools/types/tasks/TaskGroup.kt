package kotools.types.tasks

import org.gradle.api.Task

internal enum class TaskGroup {
    BUILD, DOCUMENTATION, HELP;

    override fun toString(): String = name.toLowerCase()
}

internal fun Task.group(value: TaskGroup) {
    group = "$value"
}
