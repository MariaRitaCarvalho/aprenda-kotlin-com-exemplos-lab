// Enumeração - Níveis de formação
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Classe - Usuário
data class Usuario(val nome: String, val idade: Int, val email: String) {
    override fun toString() = nome
}

// Classe - Conteúdo educacional
data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

// Classe - Formação
class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()

    // Método para matricular um usuário na formação
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
        }
    }

    // Método para listar os usuários matriculados
    fun listarInscritos() {
        println("Usuários matriculados na formação $nome (Nível: $nivel):")
        inscritos.forEach { println(it) }
    }

    // Método para listar os conteúdos da formação
    fun listarConteudos() {
        println("Conteúdos da formação $nome (Nível: $nivel):")
        conteudos.forEach { println("Nome: ${it.nome}, Duração: ${it.duracao} minutos") }
        println("-----------------------------------------------------------------------------------------------")
    }
}

fun main() {
    // Criação de usuários
    val usuario1 = Usuario("Alice", 25, "alice@email.com")
    val usuario2 = Usuario("Bob", 30, "bob@email.com")

    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Algoritmos e Estruturas de Dados", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    // Criação de formações
    val formacao1 = Formacao("Formação de Desenvolvedor Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))

    // Matrícula de alunos nas formações
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    // Listagem de usuários matriculados e conteúdos das formações
    formacao1.listarInscritos()
    formacao1.listarConteudos()
}