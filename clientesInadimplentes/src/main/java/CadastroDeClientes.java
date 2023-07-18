import java.util.*;
import java.util.stream.Collectors;

public class CadastroDeClientes {

    List<Cliente> listaClientes = new ArrayList<>();
    private HashMap<Integer, Cliente> mapaIdCliente = new HashMap<>();

    private final EntradaDeDados leitor;
    private final String DIGITE_OPCAO_DESEJADA = "Digite a opção desejada: ";
    private final String OPCAO_SAIR = "x";
    private final String OPCAO_CARREGAR_CLIENTES_LOTE = "1";
    private final String OPCAO_REMOVER_DUPLICADOS = "2";
    private final String OPCAO_IMPRIMIR_LISTA = "3";
    private final String OPCAO_LISTAR_INADIMPLENTE = "4";
    private final String OPCAO_BUSCAR_POR_ID = "5";

    public CadastroDeClientes(EntradaDeDados leitor) {
        this.leitor = leitor;
        iniciaApp();
    }

    public void processar() {

        String opcaoDigitada = obterEntradaDoUsuario(leitor);

        while(!escolheuSair(opcaoDigitada)){
            tratarOpcaoSelecionada(opcaoDigitada);
            opcaoDigitada = obterEntradaDoUsuario(leitor);
        }
    }

    private void iniciaApp(){
        carregaNomeApp();
    }

    private void carregaNomeApp(){
        System.out.println("******************************************");
        System.out.println("******** CLIENTES INADIMPLENTES **********");
        System.out.println("******************************************");
    }

    private String obterEntradaDoUsuario(EntradaDeDados leitor){
        carregaMenu();
        System.out.print(DIGITE_OPCAO_DESEJADA);
        return leitor.obterEntrada().toLowerCase();
    }

    private boolean escolheuSair(String opcaoDigitada){
        return opcaoDigitada.equals(OPCAO_SAIR);
    }

    private void carregaMenu() {
        System.out.println("********  DIGITE A OPÇÃO DESEJADA   ******");
        System.out.println("1 - CARREGAR LISTA DE CLIENTES");
        System.out.println("2 - REMOVER CLIENTES DUPLICADOS");
        System.out.println("3 - LISTAR 100 PRIMEIROS CLIENTES");
        System.out.println("4 - LISTAR INADIMPLENTES");
        System.out.println("5 - BUSCAR POR ID");
        System.out.println("X - SAIR");
    }

    private void tratarOpcaoSelecionada(String opcaoDigitada) {
        switch (opcaoDigitada){
            case OPCAO_SAIR:
                break;
            case OPCAO_CARREGAR_CLIENTES_LOTE:
                listaClientes = carregarClientesEmLote();
                inserirCliente(listaClientes);
                System.out.println("Lista de Clientes carregada com sucesso!");
                System.out.println("Quantidade de Registros = " + listaClientes.size());
                pularLinha(2);
                break;
            case OPCAO_REMOVER_DUPLICADOS:
                listaClientes = removerDuplicados(listaClientes);
                System.out.println("Duplicados removidos com sucesso!");
                System.out.println("Quantidade de Registros sem repetições = " + listaClientes.size());
                pularLinha(2);
                break;
            case OPCAO_IMPRIMIR_LISTA:
                ImprimirLista(listaClientes);
                pularLinha(2);
                break;
            case OPCAO_LISTAR_INADIMPLENTE:
                ImprimirLista(ListarInadimplentes());
                pularLinha(2);
                break;
            case OPCAO_BUSCAR_POR_ID:
                buscaPorIdHashMap();
                pularLinha(2);
                break;
            default:
                opcaoInvalida();
                break;
        }
    }

    private void opcaoInvalida(){
        System.out.println("Opção INVÁLIDA. Tente novamente.");
    }

    public void pularLinha(int numeroDeLinhas){
        for (int i = 1; i <= numeroDeLinhas; i++) {
            System.out.println();
        }
    }

    private List<Cliente> carregarClientesEmLote(){

        return new CarregarDadosExternos().carregarClientesCVS();
    }

    private List<Cliente> removerDuplicados(List<Cliente> lista){

        return new ArrayList<>(new HashSet<>(lista));
    }

    private void ImprimirLista(List<Cliente> listaClientes) {

        if (listaClientes.isEmpty()) {
            System.out.println("Lista Vazia!");
            return;
        }

        Collections.sort(listaClientes);

        int contador = 0;
        while (contador < listaClientes.size() && contador < 100) {

            System.out.println(listaClientes.get(contador).toString());
            contador++;
        }
    }

    private List<Cliente> ListarInadimplentes(){

        List<Cliente> listaInadimplentes = listaClientes
                .stream().filter(s -> s.getInadimplente() == 1)
                .collect(Collectors.toList());

        return listaInadimplentes;
    }

    private void buscaPorIdHashMap(){
        System.out.print("Digite o id do cliente: ");
        Integer id = leitor.obterEntradaAsInt();
        Cliente cliente = this.mapaIdCliente.get(id);
        if(cliente != null){
            System.out.println("Cliente localizado!");
            System.out.println(cliente);
        } else {
            System.out.println("Nenhum cliente localizado para o id: " + id);
        }
    }

    private void inserirCliente(List<Cliente> listaClientes){

        for(Cliente cliente : listaClientes){
            mapaIdCliente.put(cliente.getId(), cliente);
        }
    }

}
