package utils

object ExecutionUtils {

  trait REPL[Input, Result] {

    def read(): Input
    def eval(in: Input): Result
    def print(r: Result)

    def run =
      while (true) {
        val input = read()
        val result = eval(input)
        print(result)
      }

  }

}