package tutorial

data class User(var firstName: String?, var lastName: String? = null)

val jane = User("Jane") // In this case, label is not required
val john = User("John", "Doe")
val joe = User(firstName = "Joe", lastName = "Doe")
