// Classe base Veiculo
class Veiculo {
    // Atributos
    private String marca;
    private String modelo;
    private int ano;
    private int velocidadeMaxima;
    private int velocidadeAtual;

    // Construtor
    public Veiculo(String marca, String modelo, int ano, int velocidadeMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0; // Inicializa a velocidade atual como 0
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    // Métodos
    public void acelerar(int incremento) {
        if (velocidadeAtual + incremento <= velocidadeMaxima) {
            velocidadeAtual += incremento;
        } else {
            velocidadeAtual = velocidadeMaxima;
        }
    }

    public void reduzirVelocidade(int decremento) {
        if (velocidadeAtual - decremento >= 0) {
            velocidadeAtual -= decremento;
        } else {
            velocidadeAtual = 0;
        }
    }

    public void obterStatus() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Velocidade Máxima: " + velocidadeMaxima + " km/h");
        System.out.println("Velocidade Atual: " + velocidadeAtual + " km/h");
    }
}

// Subclasse Carro
class Carro extends Veiculo {
    // Atributo específico para Carro
    private boolean arCondicionado;

    // Construtor
    public Carro(String marca, String modelo, int ano, int velocidadeMaxima) {
        super(marca, modelo, ano, velocidadeMaxima);
        this.arCondicionado = false; // Inicializa o ar condicionado como desligado
    }

    // Método para ligar/desligar o ar condicionado
    public void ligarArCondicionado() {
        arCondicionado = true;
    }

    public void desligarArCondicionado() {
        arCondicionado = false;
    }

    // Sobrescrita do método obterStatus para incluir informações específicas de Carro
    @Override
    public void obterStatus() {
        super.obterStatus();
        System.out.println("Ar Condicionado: " + (arCondicionado ? "Ligado" : "Desligado"));
    }
}

// Subclasse Moto
class Moto extends Veiculo {
    // Construtor
    public Moto(String marca, String modelo, int ano, int velocidadeMaxima) {
        super(marca, modelo, ano, velocidadeMaxima);
    }

    // Método para empinar a moto
    public void empinarMoto() {
        if (getVelocidadeAtual() > 20 && getVelocidadeAtual() < 50) {
            System.out.println("Empinando a moto!");
        } else {
            System.out.println("Velocidade não adequada para empinar a moto.");
        }
    }
}

// Subclasse Caminhão
class Caminhao extends Veiculo {
    // Atributo específico para Caminhão
    private double cargaMaxima;

    // Construtor
    public Caminhao(String marca, String modelo, int ano, int velocidadeMaxima, double cargaMaxima) {
        super(marca, modelo, ano, velocidadeMaxima);
        this.cargaMaxima = cargaMaxima;
    }

    // Método para obter carga máxima
    public double getCargaMaxima() {
        return cargaMaxima;
    }

    // Sobrescrita do método obterStatus para incluir informações específicas de Caminhão
    @Override
    public void obterStatus() {
        super.obterStatus();
        System.out.println("Carga Máxima: " + cargaMaxima + " toneladas");
    }
}

// Classe principal Main
public class Main {
    public static void main(String[] args) {
        // Criando instâncias de veículos
        Carro carro = new Carro("Honda", "Civic", 2022, 180);
        Moto moto = new Moto("Yamaha", "F250", 2021, 120);
        Caminhao caminhao = new Caminhao("Volvo", "FH540", 2023, 100, 1.0);

        // Demonstrando funcionalidades do Carro
        carro.obterStatus();
        carro.ligarArCondicionado();
        carro.acelerar(60); // Carro acelerando
        System.out.println(); // Espaçamento entre os status do carro e da moto
        carro.obterStatus();

        // Demonstrando funcionalidades da Moto
        System.out.println(); // Espaçamento entre os status do carro e da moto
        moto.acelerar(80); // Tentando empinar a moto
        moto.obterStatus();
        moto.empinarMoto(); // Empinando a moto
        System.out.println();
        moto.reduzirVelocidade(40); // Reduzindo a velocidade da moto
        moto.obterStatus();
        moto.empinarMoto();

        // Demonstrando funcionalidades do Caminhão
        System.out.println(); // Espaçamento entre os status da moto e do caminhão
        caminhao.obterStatus();
    }
}