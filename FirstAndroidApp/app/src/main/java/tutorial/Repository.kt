package tutorial

import kotlin.collections.mutableListOf


/**
 * Returns a list of formatted user names.
 * @return a list of formatted user names
 */
val User.formattedName: String
    get() {
        return if (lastName != null) {
            if (firstName != null) {
                "$firstName $lastName"
            } else {
                lastName ?: "Unknown"
            }
        } else firstName ?: "Unknown"
    }

object Repository {
    private val _users = mutableListOf<User>()
    val users: List<User>
        get() = _users

    // keeping the constructor private to enforce the usage of getInstance
    init {
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")

        _users.apply {
            add(user1)
            add(user2)
            add(user3)
        }
    }
}