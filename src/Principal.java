import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Ecommerce comercio = new Ecommerce("Mercado Nada Livre");

		Categoria cat1 = new Categoria("Eletro");
		Categoria cat2 = new Categoria("Cama, Mesa e Banho");
		comercio.adicionaCategoria(cat1);
		comercio.adicionaCategoria(cat2);

		cat1.adicionaProduto(new Produto("Liquidificador", 20));
		cat1.adicionaProduto(new Produto("Geladeira Topzinha", 4000));

		cat2.adicionaProduto(new Produto("Toalha", 20));
		cat2.adicionaProduto(new Produto("Lençol Cama King", 200)); 

		Usuario usu1 = new Usuario("admin", "12345", "Administrador");
		Usuario usu2 = new Vendedor("ven", "12345", "Vendedor");
		Usuario usu3 = new Cliente("cli", "12345", "Cliente");

		comercio.adicionaUsuario(usu1);
		comercio.adicionaUsuario(usu2);
		comercio.adicionaUsuario(usu3);

		System.out.print("Mercado Nada Livre\n  \n" + "");

		System.out.print("-=-=-=-=-=-=-=- Menu -=-=-=-=-=-=-=-\n \n  Bem vindo!\n");

		System.out.print("\n1. Login\n2. Cadastro\n3. Sair\nEscolha uma opção (1 a 3): ");

		int escolha = Integer.parseInt(sc.nextLine());

		while (escolha != 3) {

			if (escolha == 1) {
				System.out.print("\n1. Administrador\n2. Vendedor\n3. Cliente\n4. Voltar\nEscolha uma opção (1 a 4): ");
				escolha = Integer.parseInt(sc.nextLine());
				while (escolha != 4) {

					if (escolha == 1 || escolha == 2 || escolha == 3);
					System.out.print("Digite o login: ");
					String login = sc.nextLine();
	
					System.out.print("Digite a senha: ");
					String senha = sc.nextLine();
	
					Usuario logado = comercio.usuarioLogin(login, senha);
	
					if (logado == null) {
						System.out.println("Usu�rio n�o cadastrado");
					} else if (escolha == 1) {
						System.out.print("\n-=-=-=-=-=-=-=- Categorias -=-=-=-=-=-=-=-\n");
						System.out.print("\n1. Listar categorias\n2. Criar categorias\n3. Editar categorias\n4. Remover categorias\n5. Voltar\nEscolha uma opção (1 a 5): ");
						escolha = Integer.parseInt(sc.nextLine());
						while (escolha != 5) {
							if (escolha == 1) {
								comercio.exibeCategorias();
							} else if (escolha == 2) {
								System.out.print("Digite o nome da categoria: ");
								String nomecat = sc.nextLine();
								Categoria cat = new Categoria(nomecat);
								comercio.adicionaCategoria(cat);
							} else if (escolha == 3) {	
								comercio.exibeCategorias();
								System.out.print("Selecione a categoria que deseja editar: ");
								int poscat = Integer.parseInt(sc.nextLine());
								Categoria cat = comercio.buscaCategoria(poscat);
								System.out.print("Digite o novo nome da categoria: ");
								String novonome = sc.nextLine();
								cat.setNome(novonome);
								comercio.exibeCategorias();
							} else if (escolha == 4) {
								comercio.exibeCategorias();
								System.out.print("Selecione a categoria: ");
								int poscat = Integer.parseInt(sc.nextLine());
								comercio.removeCategoria(poscat-1);
							
							} else {
								System.out.println("Opção inválida");
							}
	
							System.out.print("\n1. Listar categorias\n2. Criar categorias\n3. Editar categorias\n4. Remover categorias\n5. Voltar\nEscolha uma opção (1 a 5): ");
							escolha = Integer.parseInt(sc.nextLine());
						}
	
					} else if (escolha == 2) {
						comercio.usuarioLogin(login, senha);
						System.out.println("\n-=-=-=-=-=-=-=- Produtos -=-=-=-=-=-=-=-\n");
						System.out.print("1. Listar produto\n2. Criar produto\n3. Editar produto\n4. Remover produto\n5. Voltar\nEscolha uma opção (1 a 5); ");
						escolha = Integer.parseInt(sc.nextLine());
						while (escolha != 5) {
							if (escolha == 1) {
								comercio.exibeCategorias();
							} else if (escolha == 2) {
								System.out.print("Digite o nome do produto: ");
								String nomepro = sc.nextLine();
								System.out.print("Digite o preço do produto: ");
								float preco = Float.parseFloat(sc.nextLine());
								comercio.exibeCategorias();
								System.out.print("Selecione a categoria: ");
								int ncat = Integer.parseInt(sc.nextLine());
								Categoria cat = comercio.buscaCategoria(ncat);
								Produto pro = new Produto(nomepro, preco);
								cat.adicionaProduto(pro);
							} else if (escolha == 3) {
								comercio.exibeCategorias();
								System.out.print("\n1. Nome\n2. Preço\n3. Voltar\nEscolha uma opção (1 a 3): ");
								escolha = Integer.parseInt(sc.nextLine());
								while (escolha != 3) {
									if (escolha == 1) {
										System.out.print("Selecione a categoria: ");
										int ncat = Integer.parseInt(sc.nextLine());
										Categoria cat = comercio.buscaCategoria(ncat);
										System.out.print("Selecione o produto: ");
										int pospro = Integer.parseInt(sc.nextLine());
										Produto produto = cat.buscaProdutoPos(pospro);
										System.out.print("Digite o novo nome do produto: ");
										String novonome = sc.nextLine();
										produto.setNome(novonome);
									} else if (escolha == 2) {
										System.out.print("Selecione a categoria: ");
										int ncat = Integer.parseInt(sc.nextLine());
										Categoria cat = comercio.buscaCategoria(ncat);
										System.out.print("Selecione o produto: ");
										int pospro = Integer.parseInt(sc.nextLine());
										Produto produto = cat.buscaProdutoPos(pospro);
										System.out.print("Digite o novo pre�o: ");
										float novopreco = Float.parseFloat(sc.nextLine());
										produto.setPreco(novopreco);
									} else {
										System.out.println("Opção inválida");
									}
									System.out.print("\n1. Nome\n2. Preço\n3. Voltar\nEscolha uma opção (1 a 3): ");
									escolha = Integer.parseInt(sc.nextLine());
								}
							} else if (escolha == 4) {
								System.out.print("Selecione a categoria: ");
								int poscat = Integer.parseInt(sc.nextLine());
								Categoria cat = comercio.buscaCategoria(poscat);
								System.out.print("Digite o nome do produto: ");
								String nomepro = sc.nextLine();
								Produto produto = comercio.buscaProduto(nomepro);
								cat.getProdutos().remove(produto);
	
							} else {
								System.out.println("Opção inválida");
							}
	
							System.out.println("\n-=-=-=-=-=-=-=- Produtos -=-=-=-=-=-=-=-\n");
							System.out.print("1. Listar produto\n2. Criar produto\n3. Editar produto\n4. Remover produto\n5. Voltar\nEscolha uma opção (1 a 5); ");
							escolha = Integer.parseInt(sc.nextLine());
						}
	
					} else if (escolha == 3) {
						System.out.print("\n-=-=-=-=-=-=-=- Opções -=-=-=-=-=-=-=-\n");
						System.out.print("\n1. Buscar\n2. Listar categorias\n3. Carrinho de Compras\n4. Sair\nEscolha uma opção (1 a 4): ");
						escolha = Integer.parseInt(sc.nextLine());
						while (escolha != 4) {
							if (escolha == 1) {
								System.out.print("Digite o nome do produto: ");
								String nomepro = sc.nextLine();
								Produto produto = comercio.buscaProduto(nomepro);
								System.out.println(produto);
	
							} else if (escolha == 2) {
								comercio.exibeCategorias();
							} else if (escolha == 3) {
								System.out.println("\n-=-=-=-=-=-=-=- Carrinho de Compras -=-=-=-=-=-=-=-\n");
								System.out.print("1. Exibir carrinho\n2. Adicionar ao carrinho\n3. Finalizar compra\n4. Sair\nEscolha uma opção (1 a 4): ");
								escolha = Integer.parseInt(sc.nextLine());
								while (escolha != 4) {
									if (escolha == 1) {
										System.out.println(logado.getCarrinho());
									} else if (escolha == 2) {
										comercio.exibeCategorias();
										System.out.print("Digite o número da categoria: ");
										int poscat = Integer.parseInt(sc.nextLine());
										Categoria cat = comercio.buscaCategoria(poscat);
										System.out.print("Digite o número do produto: ");
										int pospro = Integer.parseInt(sc.nextLine());
										Produto produto = cat.buscaProdutoPos(pospro);
										logado.getCarrinho().adicionaProduto(produto);
										
									} else if (escolha == 3) {
										System.out.print("\n1. Escolher endereço\n2. Adicionar endereço\n3. Sair\nEscolha uma opção (1 a 3): ");
										escolha = Integer.parseInt(sc.nextLine());
										while (escolha != 3) {
											if (escolha == 1) {
												System.out.println(logado.exibeEnderecos());
												System.out.print("Selecione o endere�o: ");
												int escolhe = Integer.parseInt(sc.nextLine());
												Endereco endereco = logado.buscaEndereco(escolhe);
												System.out.println("\n-=-=-=-=-=-=-=- Forma de Pagamento -=-=-=-=-=-=-=-\n");
												System.out.print("1. Boleto\n2. Cartão de crédito\n3. Pix\n4. Transferência\n5. Voltar\nEscolha uma opção (1 a 5): ");
												escolha = Integer.parseInt(sc.nextLine());
												while (escolha != 5) {
													if (escolha == 1) {
														System.out.println("\nBoleto pago");
													} else if (escolha == 2) {
														System.out.println("\nCartão utilizado");
													} else if (escolha == 3) {
														System.out.println("\nPix enviado");
													} else if (escolha == 4) {
														System.out.println("\nTransferência realizada");
													} else {
														System.out.println("\nOpção inválida");
													}
													System.out.println("\n-=-=-=-=-=-=-=- Compra Realizada -=-=-=-=-=-=-=-\n");
													System.out.print("1. Boleto\n2. Cartão de crédito\n3. Pix\n4. Transferência\n5. Voltar\nEscolha uma opção (1 a 4): ");
													escolha = Integer.parseInt(sc.nextLine());
												}

											} else if (escolha == 2) {
												System.out.print("Informe o endereço: \n");
												System.out.print("CEP: ");
												String cep = sc.nextLine();
												System.out.print("Número: ");
												String numero = sc.nextLine();
												System.out.print("Bairro: ");
												String bairro = sc.nextLine();
												System.out.print("Cidade: ");
												String cidade = sc.nextLine();
												System.out.print("Estado: ");
												String estado = sc.nextLine();
												System.out.print("País: ");
												String pais = sc.nextLine();
												Endereco end = new Endereco(cep, numero, bairro, cidade, estado, pais);
												logado.adicionaEndereco(end);
												System.out.println(logado.exibeEnderecos());
											} else {
												System.out.println("Opção inválida");
											}
											System.out.print("\n1. Escolher endereço\n2. Adicionar endereço\n3. Sair\nEscolha uma opção (1 a 3): ");
											escolha = Integer.parseInt(sc.nextLine());
										}
									} else {
										System.out.println("Opção inválida");
									}
									System.out.println("\n-=-=-=-=-=-=-=- Carrinho de Compras -=-=-=-=-=-=-=-\n");
									System.out.print("1. Exibir carrinho\n2. Adicionar ao carrinho\n3. Finalizar compra\n4. Sair\nEscolha uma opção (1 a 4): ");
									escolha = Integer.parseInt(sc.nextLine());
								}
	
							} else {
								System.out.println("Opção inválida");
							}
							System.out.print("\n-=-=-=-=-=-=-=- Opções -=-=-=-=-=-=-=-\n");
							System.out.print("\n1. Buscar\n2. Listar categorias\n3. Carrinho de Compras\n4. Sair\nEscolha uma opção (1 a 4): ");
							escolha = Integer.parseInt(sc.nextLine());
						}
	
					} else {
						System.out.println("Opção Inválida");
					}
					System.out.print("\n1. Administrador\n2. Vendedor\n3. Cliente\n4. Voltar\nEscolha uma opção (1 a 4): ");
					escolha = Integer.parseInt(sc.nextLine());

	
				}
			} else if (escolha == 2) {
				System.out.print("1. Vendedor\n2. Cliente\n3. Voltar\nEscolha uma opção (1 a 3): ");
				escolha = Integer.parseInt(sc.nextLine());

				if (escolha == 1 || escolha == 2) {
					System.out.print("Digite o login: ");
					String login = sc.nextLine();

					System.out.print("Digite a senha: ");
					String senha = sc.nextLine();

					System.out.print("Digite o nome: ");
					String nome = sc.nextLine();

					if (escolha == 1) {
						Vendedor vendedor = new Vendedor(login, senha, nome);
						comercio.adicionaUsuario(vendedor);
					} else if (escolha == 2) {
						Cliente cliente = new Cliente(login, senha, nome);
						comercio.adicionaUsuario(cliente);
					}
				}

			} else {
				System.out.println("Opção Inválida");
			}
			System.out.print("-=-=-=-=-=-=-=- Menu -=-=-=-=-=-=-=-\n");
			System.out.print("1. Login\n2. Cadastro\n3. Sair\nEscolha uma opção (1 a 3): ");
			escolha = Integer.parseInt(sc.nextLine());

		}

	}
}