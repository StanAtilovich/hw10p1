

class NoChatException(message: String) : RuntimeException(message)


data class Chat (val messages: MutableList<Message> = mutableListOf())
data class Message (val id: Int = 1, val text: String = "", var read: Boolean = false, var deleted: Boolean= false)


object ChatService {
    private val chats = mutableMapOf<String, Chat>()

    fun addMessage(nameUseer: String, message: Message) {
        chats.getOrPut(nameUseer) { Chat() }.messages.add(message)
    }

    fun printChats() {
        println(chats)
    }

    fun getMesseges(nameUseer: String, count: Int): List<Message> {
        var chat = chats[nameUseer] ?: throw NoChatException("Чата нет")
        return chat.messages.takeLast(count).onEach { it.read = true }
    }



    fun countUnreadChats(): Int {
        return chats.values.count { chat -> chat.messages.any { !it.read } }
    }

    fun deleteMessages(nameUseer: String, messageId: Int) {
        chats[nameUseer]?.messages.orEmpty().take(messageId).onEach { it.deleted = true }
        if (chats[nameUseer]?.messages.orEmpty().count { !it.deleted } == 0) {
            chats.remove(nameUseer)
        }
    }

    fun deleteChat(nameUseer: String) {
        chats.remove(nameUseer)
    }



}
