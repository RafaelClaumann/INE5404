package view;

import control.EleitorControle;
import control.PartidoControle;
import control.PrefeitoControle;
import control.SecaoEleitoralControle;
import control.UrnaEleitoralControle;
import control.VereadorControle;
import control.ZonaEleitoralControle;
import exceptions.EEntradaInvalida;
import exceptions.EObjetoJaDefinido;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Eleitor;
import model.PartidoPolitico;
import model.Prefeito;
import model.SecaoEleitoral;
import model.UrnaEleitoral;
import model.Vereador;
import model.ZonaEleitoral;

public class Main {

    public static void main(String[] args) {
        desserialize();
        menuPrincipal();

    }
    static ZonaEleitoralControle zonaEleitoralController = ZonaEleitoralControle.getZonaControle();
    static SecaoEleitoralControle secaoEleitoralController = SecaoEleitoralControle.getSecaoControle();
    static EleitorControle eleitorController = EleitorControle.getEleitorControle();
    static PartidoControle partidoPoliticoController = PartidoControle.getPartidoControle();
    static VereadorControle vereadorController = VereadorControle.getVeradorControle();
    static PrefeitoControle prefeitoController = PrefeitoControle.getPrefeitoControle();
    static UrnaEleitoralControle urnaEleitoralController = UrnaEleitoralControle.getUrnaControle();

    public static void cadastrarZona() {
        ZonaEleitoral zonaEleitoral = new ZonaEleitoral();
        try {
            zonaEleitoral.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da Zona Eleitoral:", "Cadastrar Zona Eleitoral", JOptionPane.INFORMATION_MESSAGE)));
            zonaEleitoral.setLocalizacao(JOptionPane.showInputDialog(null, "Digite a localização da Zona Eleitoral: ", "Cadastrar Zona Eleitoral", JOptionPane.INFORMATION_MESSAGE));
            zonaEleitoralController.insert(zonaEleitoral);
            zonaEleitoralController.serializacao();
        } catch (EObjetoJaDefinido e) {
            JOptionPane.showMessageDialog(null, "Zona eleitoral já cadastrada!", "Cadastrar Zona Eleitoral", JOptionPane.ERROR_MESSAGE);
        } catch (EEntradaInvalida e) {
            JOptionPane.showMessageDialog(null, "O Endereço deve conter no mínimo 5 caracteres!", "Cadastrar Zona Eleitoral", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira os caracteres da forma correta!", "Cadastrar Zona Eleitoral", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!", "Cadastrar Zona Eleitoral", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cadastrarSecao() {
        SecaoEleitoral secaoEleitoral = new SecaoEleitoral();
        try {
            secaoEleitoral.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da Secão Eleitoral", "Cadastrar Seção Eleitoral", JOptionPane.INFORMATION_MESSAGE)));
            secaoEleitoral.setZonaEleitoral(zonaEleitoralController.searchByNum(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da Zona Eleitoral", "Cadastrar Seção Eleitoral", JOptionPane.INFORMATION_MESSAGE))));
            if (secaoEleitoral.getZonaEleitoral() == null) {
                JOptionPane.showMessageDialog(null, "Zona não encontrada, Seção Eleitoral não pode ser cadastrada.", "Cadastrar Seção Eleitoral", JOptionPane.ERROR_MESSAGE);
                return;
            }
            secaoEleitoralController.insert(secaoEleitoral);
            secaoEleitoralController.serializacao();
        } catch (EObjetoJaDefinido e) {
            JOptionPane.showMessageDialog(null, "Seção eleitoral já cadastrada!", "Cadastrar Seção Eleitoral", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira os caracteres da forma correta!", "Cadastrar Seção Eleitoral", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Zona eleitoral não encontrada!", "Cadastrar Seção Eleitoral", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!", "Cadastrar Seção Eleitoral", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cadastraUrna() {
        UrnaEleitoral urnaEleitoral = new UrnaEleitoral();
        try {
            urnaEleitoral.setSerial(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da Urna Eleitoral", "Cadastrar Urna Eleitoral", JOptionPane.INFORMATION_MESSAGE)));
            urnaEleitoral.setSecao(secaoEleitoralController.searchByNum(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da Seção Eleitoral", "Cadastrar Urna Eleitoral", JOptionPane.INFORMATION_MESSAGE))));
            urnaEleitoralController.insert(urnaEleitoral);

            if (urnaEleitoral.getSecao() == null) {
                JOptionPane.showMessageDialog(null, "Seção não encontrada, Urna Eleitoral não pode ser cadastrada.", "Cadastrar Urna Eleitoral", JOptionPane.ERROR_MESSAGE);
                return;
            }
            secaoEleitoralController.serializacao();
            urnaEleitoralController.serializacao();
        } catch (EObjetoJaDefinido e) {
            JOptionPane.showMessageDialog(null, "Urna Eleitoral já cadastrada!", "Cadastrar Urna Eleitoral", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira os caracteres da maneira correta!", "Cadastrar Urna Eleitoral", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ArithmeticException | ClassNotFoundException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!", "Cadastrar Urna Eleitoral", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cadastrarEleitor() {
        Eleitor eleitor = new Eleitor();
        try {
            eleitor.setNome(JOptionPane.showInputDialog(null, "Digite o nome do eleitor", "Cadastrar Eleitor", JOptionPane.INFORMATION_MESSAGE));
            eleitor.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do eleitor", "Cadastrar Eleitor", JOptionPane.INFORMATION_MESSAGE));
            eleitor.setNumeroTitulo(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do titulo do Eleitor", "Cadastrar Eleitor", JOptionPane.INFORMATION_MESSAGE)));
            eleitor.setSecaoEleitoral(secaoEleitoralController.searchByNum(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da seção do Eleitor", "Cadastrar Eleitor", JOptionPane.INFORMATION_MESSAGE))));
            if (eleitor.getSecaoEleitoral() == null) {
                JOptionPane.showMessageDialog(null, "Secao Eleitoral não encontrada.", "Erro ao Cadastrar Eleitor", JOptionPane.ERROR_MESSAGE);
                return;
            }
            eleitor.setZonaEleitoral(zonaEleitoralController.searchByNum(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da zona do Eleitor", "Cadastrar Eleitor", JOptionPane.INFORMATION_MESSAGE))));
            if (eleitor.getZonaEleitoral() == null) {
                JOptionPane.showMessageDialog(null, "Zona Eleitoral não encontrada.", "Erro ao Cadastrar Eleitor", JOptionPane.ERROR_MESSAGE);
                return;
            }
            eleitorController.insert(eleitor);
            eleitorController.serializacao();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira os caracteres da forma correta!", "Cadastrar Eleitor", JOptionPane.ERROR_MESSAGE);
        } catch (EEntradaInvalida e) {
            JOptionPane.showMessageDialog(null, "O cpf do eleitor deve conter pelo menos 5 algarismos!", "Cadastrar Eleitor", JOptionPane.ERROR_MESSAGE);
        } catch (EObjetoJaDefinido e) {
            JOptionPane.showMessageDialog(null, "Eleitor já cadastrado!", "Cadastrar Eleitor", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ArithmeticException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado.", "Cadastrar Eleitor", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cadastrarPartidoPolitico() {
        PartidoPolitico partidoPolitico = new PartidoPolitico();
        try {
            partidoPolitico.setNome(JOptionPane.showInputDialog(null, "Digite o nome do Partido Político:", "Cadastrar Partido Politico", JOptionPane.INFORMATION_MESSAGE));
            partidoPolitico.setSigla(JOptionPane.showInputDialog(null, "Digite a sigla do Partido Político:", "Cadastrar Partido Politico", JOptionPane.INFORMATION_MESSAGE));
            partidoPoliticoController.insert(partidoPolitico);
            partidoPoliticoController.serializacao();
        } catch (EObjetoJaDefinido e) {
            JOptionPane.showMessageDialog(null, "Partido já cadastrado!", "Cadastrar Partido", JOptionPane.ERROR_MESSAGE);
        } catch (EEntradaInvalida e) {
            JOptionPane.showMessageDialog(null, "No mínimo 5 caracteres para o Partido e 2 para sua Sigla!", "Cadastrar Partido", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ClassNotFoundException | ArithmeticException | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!", "Cadastrar Partido", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cadastrarCandidatoPrefeito() {
        Prefeito prefeito = new Prefeito();
        try {
            Eleitor eleitor = eleitorController.searchByTitulo(Integer.parseInt(JOptionPane.showInputDialog(null, "Titulo do eleitor que será candidato a Prefeito", "Cadastrar Prefeito", JOptionPane.INFORMATION_MESSAGE)));
            if (vereadorController.searchByTitulo(eleitor.getNumeroTitulo()) != null) {
                JOptionPane.showMessageDialog(null, "Eleitor ja é candidato a vereador.", "Cadastrar Vereador", JOptionPane.ERROR_MESSAGE);
                return;
            }
            prefeito.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite número do Prefeito", "Cadastrar Prefeito", JOptionPane.INFORMATION_MESSAGE)));
            prefeito.setNome(eleitor.getNome());
            prefeito.setCpf(eleitor.getCpf());
            prefeito.setEndereco(eleitor.getEndereco());
            prefeito.setNumeroTitulo(eleitor.getNumeroTitulo());
            prefeito.setSecaoEleitoral(eleitor.getSecaoEleitoral());
            prefeito.setZonaEleitoral(eleitor.getZonaEleitoral());
            prefeitoController.insert(prefeito);

            partidoPoliticoController.desserializacao();
            PartidoPolitico partidoPolitico = partidoPoliticoController.searchBySigla(JOptionPane.showInputDialog(null, "Digite a sigla do partido político", "Cadastrar Prefeito", JOptionPane.INFORMATION_MESSAGE));
            prefeito.setPartidoPolitico(partidoPolitico);
            partidoPolitico.setPrefeito(prefeito);
            partidoPoliticoController.update(partidoPolitico);

            prefeitoController.serializacao();
            partidoPoliticoController.serializacao();
        } catch (EObjetoJaDefinido e) {
            JOptionPane.showMessageDialog(null, "Prefeito já cadastrado!", "Cadastrar Prefeito", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira os caracteres da forma correta!", "Cadastrar Prefeito", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ClassNotFoundException | ArithmeticException | NullPointerException | EEntradaInvalida e) {
            JOptionPane.showMessageDialog(null, "Ops, algo deu errado!", "Cadastrar Prefeito", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cadastrarCandidatoVereador() {
        Vereador vereador = new Vereador();
        try {
            Eleitor eleitor = eleitorController.searchByTitulo(Integer.parseInt(JOptionPane.showInputDialog(null, "Titulo do eleitor que será candidato a Vereador", "Cadastrar Vereador", JOptionPane.INFORMATION_MESSAGE)));
            if (prefeitoController.searchByTitulo(eleitor.getNumeroTitulo()) != null) {
                JOptionPane.showMessageDialog(null, "Eleitor ja é candidato a prefeito.", "Cadastrar Vereador", JOptionPane.ERROR_MESSAGE);
                return;
            }
            vereador.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite número do Vereador", "Cadastrar Vereador", JOptionPane.INFORMATION_MESSAGE)));
            vereador.setNome(eleitor.getNome());
            vereador.setCpf(eleitor.getCpf());
            vereador.setEndereco(eleitor.getEndereco());
            vereador.setNumeroTitulo(eleitor.getNumeroTitulo());
            vereador.setSecaoEleitoral(eleitor.getSecaoEleitoral());
            vereador.setZonaEleitoral(eleitor.getZonaEleitoral());
            vereadorController.insert(vereador);

            PartidoPolitico partidoPolitico = partidoPoliticoController.searchBySigla(JOptionPane.showInputDialog(null, "Digite a sigla do partido político", "Cadastrar Vereador", JOptionPane.INFORMATION_MESSAGE));
            vereador.setPartidoPolitico(partidoPolitico);
            partidoPolitico.setVereadores(vereadorController.searchByPartido(partidoPolitico));
            partidoPoliticoController.update(partidoPolitico);

            vereadorController.serializacao();
            partidoPoliticoController.serializacao();
        } catch (EObjetoJaDefinido ex) {
            JOptionPane.showMessageDialog(null, "Vereador já cadastrado.", "Cadastrar Vereador", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ClassNotFoundException | ArithmeticException | NumberFormatException | NullPointerException | EEntradaInvalida e) {
            JOptionPane.showMessageDialog(null, "Ops, aconteceu algum erro!", "Cadastrar Vereador", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void desserialize() {
        try {
            zonaEleitoralController.desserializacao();
            secaoEleitoralController.desserializacao();
            urnaEleitoralController.desserializacao();
            partidoPoliticoController.desserializacao();
            eleitorController.desserializacao();
            vereadorController.desserializacao();
            prefeitoController.desserializacao();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ops, aconteceu algum erro!", "Desserialização", JOptionPane.ERROR_MESSAGE);
        }
        menuPrincipal();
    }

    public static void Votacao() {
        Eleitor eleitor = eleitorController.searchByTitulo(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o titulo do eleitor", "Votação", JOptionPane.QUESTION_MESSAGE)));

        try {
            eleitor.setVotou(true);
        } catch (EObjetoJaDefinido ex) {
            JOptionPane.showMessageDialog(null, "Este eleitor já votou!", "Votação", JOptionPane.ERROR_MESSAGE);
        }

        printAllPrefeito();
        printAllVereador();

        try {
            Prefeito prefeito = prefeitoController.searchByNum(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do prefeito", "Votação", JOptionPane.QUESTION_MESSAGE)));
            Vereador vereador = vereadorController.searchByNum(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do vereador", "Votação", JOptionPane.QUESTION_MESSAGE)));
            urnaEleitoralController.updateVotes(prefeito, vereador);

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ops, não encontrado!", "Votação", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira os dados corretamente!", "Votação", JOptionPane.ERROR_MESSAGE);
        }
        menuPrincipal();
    }

    public static void Apuracao() {
        JOptionPane.showMessageDialog(null, urnaEleitoralController.apuraVereador().getNome(), "Apuração Vereador", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, urnaEleitoralController.apuraPrefeito().getNome(), "Apuração Vereador", JOptionPane.ERROR_MESSAGE);
        menuPrincipal();
    }

    public static void printAllZonas() {
        JOptionPane.showMessageDialog(null, zonaEleitoralController.printAll(), "Exibir Zonas", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void printAllSecoes() {
        JOptionPane.showMessageDialog(null, secaoEleitoralController.printAll(), "Exibir Secoes", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void printAllUrnas() {
        JOptionPane.showMessageDialog(null, urnaEleitoralController.printAll(), "Exibir Urnas", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void printAllPartido() {
        JOptionPane.showMessageDialog(null, partidoPoliticoController.printAll(), "Exibir Partidos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void printAllEleitor() {
        JOptionPane.showMessageDialog(null, eleitorController.printAll(), "Exibir Eleitores", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void printAllPrefeito() {
        JOptionPane.showMessageDialog(null, prefeitoController.printAll(), "Exibir Prefeitos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void printAllVereador() {
        JOptionPane.showMessageDialog(null, vereadorController.printAll(), "Exibir Vereadores", JOptionPane.INFORMATION_MESSAGE);
    }

    static void menuPrincipal() {
        String valoresMenuPrincipal[] = {"Cadastro", "Listagem", "Votacao", "Apurar Votacao"};
        String entrada = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Menu Principal", JOptionPane.QUESTION_MESSAGE, null, valoresMenuPrincipal, 0);

        if (entrada != null) {
            switch (entrada) {
                case "Cadastro":
                    opcaoCadastro();
                    break;
                case "Listagem":
                    opcaoListagem();
                    break;
                case "Votacao":
                    Votacao();
                    break;
                case "Apuraca Votacao":
                    Apuracao();
                    break;
            }
        } else {
            System.exit(0);
        }
    }

    static void opcaoListagem() {
        String valoresMenuListar[] = {"Listar Zonas", "Listar Seções", "Listar Urnas", "Listar Partidos", "Listar Eleitores", "Listar Prefeitos", "Listar Vereadores"};
        String entradaListar = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Menu Listagem", JOptionPane.WARNING_MESSAGE, null, valoresMenuListar, 0);

        if (entradaListar != null) {
            switch (entradaListar) {
                case "Listar Zonas":
                    printAllZonas();
                    opcaoListagem();
                    break;
                case "Listar Seções":
                    printAllSecoes();
                    opcaoListagem();
                    break;
                case "Listar Urnas":
                    printAllUrnas();
                    opcaoListagem();
                    break;
                case "Listar Partidos":
                    printAllPartido();
                    opcaoListagem();
                    break;
                case "Listar Eleitores":
                    printAllEleitor();
                    opcaoListagem();
                    break;
                case "Listar Prefeitos":
                    printAllPrefeito();
                    opcaoListagem();
                    break;
                case "Listar Vereadores":
                    printAllVereador();
                    opcaoListagem();
                    break;
            }
        } else {
            menuPrincipal();
        }
    }

    static void opcaoCadastro() {
        String valoresMenuCadastro[] = {"Cadastrar Zonas", "Cadastrar Seções", "Cadastrar Urnas", "Cadastrar Partidos", "Cadastrar Eleitores", "Cadastrar Prefeitos", "Cadastrar Vereadores"};
        String entradaCadastro = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Menu Cadastro", JOptionPane.WARNING_MESSAGE, null, valoresMenuCadastro, 0);

        if (entradaCadastro != null) {
            switch (entradaCadastro) {
                case "Cadastrar Zonas":
                    cadastrarZona();
                    opcaoCadastro();
                    break;
                case "Cadastrar Seções":
                    cadastrarSecao();
                    opcaoCadastro();
                    break;
                case "Cadastrar Urnas":
                    cadastraUrna();
                    opcaoCadastro();
                    break;
                case "Cadastrar Partidos":
                    cadastrarPartidoPolitico();
                    opcaoCadastro();
                    break;
                case "Cadastrar Eleitores":
                    cadastrarEleitor();
                    opcaoCadastro();
                    break;
                case "Cadastrar Prefeitos":
                    cadastrarCandidatoPrefeito();
                    opcaoCadastro();
                    break;
                case "Cadastrar Vereadores":
                    cadastrarCandidatoVereador();
                    opcaoCadastro();
                    break;
            }
        } else {
            menuPrincipal();
        }
    }
}
