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
        println("------------------------------------------------------------------------------------------------")
    }
}

fun main() {
    // Criação de usuários
    val usuario1 = Usuario("Alice", 25, "alice@email.com")
    val usuario2 = Usuario("Bob", 30, "bob@email.com")
    val usuario3 = Usuario("Carlos", 22, "carlos@email.com")
    val usuario4 = Usuario("Daniela", 28, "daniela@email.com")
    val usuario5 = Usuario("Eduardo", 23, "eduardo@email.com")

    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Algoritmos e Estruturas de Dados", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Web com Kotlin", 60)

    // Criação de formações
    val formacao1 = Formacao("Formação de Desenvolvedor Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Formação de Banco de Dados", Nivel.DIFICIL, listOf(conteudo3))
    val formacao3 = Formacao("Formação de Segurança da Informação", Nivel.DIFICIL, listOf(conteudo2, conteudo3))

    // Matrícula de alunos nas formações
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario3)
    
    formacao2.matricular(usuario2)
    formacao2.matricular(usuario4)
    
    formacao3.matricular(usuario1)
    formacao3.matricular(usuario4)
    formacao3.matricular(usuario5)

    // Listagem de usuários matriculados e conteúdos das formações
    formacao1.listarInscritos()
    formacao1.listarConteudos()

    formacao2.listarInscritos()
    formacao2.listarConteudos()

    formacao3.listarInscritos()
    formacao3.listarConteudos()
}