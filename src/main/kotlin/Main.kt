fun main() {



    ChatService.addMessage("Саша", Message(1, "Привет Аня"))
    ChatService.addMessage("Аня", Message(2, "салам", true))
    ChatService.addMessage("Саша", Message(3, "что делаешь?"))
    ChatService.addMessage("Аня", Message(4, "сплю", true))
    ChatService.addMessage("Катя", Message(6, "айм хирр", false))
    ChatService.addMessage("Катя", Message(7, "степа"))
    ChatService.addMessage("Катя", Message(8, "степа попа"))
    ChatService.addMessage("Оля", Message(9, "смс оли"))
    ChatService.addMessage("Аня", Message(5, "последнее смс ани", ))

    println("Распечатка смс")
    ChatService.printChats()
    println("получить смс")
    println(ChatService.getMesseges("Катя", 2))


    println("количество непрочитаных чатов")
    println(ChatService.countUnreadChats())
    println("удаляем смс от Ани")
    ChatService.deleteMessages("Аня", 2)
    ChatService.printChats()

    println("удаляем все чаты Кати")
    ChatService.deleteChat("Катя")
    ChatService.printChats()
}