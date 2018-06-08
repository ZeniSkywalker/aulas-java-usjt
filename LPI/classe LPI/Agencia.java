public class Agencia{
   private int idAgencia;
   private String cnpj;
   private int ie; 
   private int im;
   private String razaoSocial;
   private String nomeFantasia;
   /*private Pesquisador pesquisador;
   private Avaliador avaliador;*/
   
   //constructor com apenas o id
   public Agencia(int idAgencia){
      this.idAgencia = idAgencia;
   }
   public Agencia(int idAgencia, String cnpj, int ie, int im, String razaoSocial, String nomeFantasia){
      this.idAgencia = idAgencia;
      this.cnpj = cnpj;
      this.ie = ie;
      this.im = im;
      this.razaoSocial = razaoSocial;
      this.nomeFantasia = nomeFantasia;
      /*this.avaliador = avaliador;
      this.pesquisador = pesquisador;*///removido tambem
   }
   
   public int getIdAgencia(){
      return idAgencia;
   }
   
   public void setIdAgencia(int idAgencia){
      this.idAgencia = idAgencia;
   }
   public String getCnpj(){
      return cnpj;
   }

   public int getIe(){
      return ie;
   }

   public int getIm(){
      return im;
   }

   public String getRazaoSocial(){
      return razaoSocial;
   }

   public String getNomeFantasia(){
      return nomeFantasia;
   }

   public Avaliador getAvaliador(){
      return avaliador;
   }      

   public Pesquisador getPesquisador(){
      return pesquisador;
   }      

   public void setCnpj(String cnpj){
      this.cnpj = cnpj;
   }

   public void setIe(int ie){
      this.ie = ie;
   }

   public void setIm(int im){
      this.im = im;
   }

   public void setRazaoSocial(String razaoSocial){
      this.razaoSocial = razaoSocial;
   }

   public void setNomeFantasia(String nomeFantasia){
      this.nomeFantasia = nomeFantasia;
   }

   /*public void setAvaliador(Avaliador avaliador){
      this.avaliador = avaliador;
   }

   public void setPesquisador(Pesquisador pesquisador){
      this.pesquisador = pesquisador;
   }*///retirei todo esse bloco pq, pra mim, não era necessário
   public void incluir(int idInstituicao, idPesquisador, Connection conn) {
		String sqlInsert = "INSERT INTO agencia(idInstituicao, idPesquisador, idagencia, cnpj, ie, im, razaosocial, nomefantasia) VALUES (?,?,?,?,?,?,?,?)";
		try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
         stm.setInt(1, idInstituicao);
         stm.setInt(2, idPesquisador):
         stm.setInt(3, idAgencia);			
		   stm.setString(4, getCnpj()); 
         stm.setInt(5, getIe());
         stm.setInt(6, getIm());
         stm.setString(7, getRazaoSocial());
         stm.setString(8, getNomeFantasia());
		   stm.execute();
			String query = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(query);
				ResultSet rs = stm2.executeQuery();){
				if(rs.next()){
					setIdAc(rs.getInt(1));
				} else {
					throw new SQLException("");//inserir erro
				}
			} catch (Exception e) {
		   	e.printStackTrace();
		   	try {
		   		conn.rollback();
		   	} catch (SQLException e1) {
		   		System.out.print(e1.getStackTrace());
		   	}
		 }

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
   public void excluir(Connection conn) {
		String sqlDelete = "DELETE FROM agencia WHERE idagencia = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getIdAgencia());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
   public void atualizar(Connection conn) {
		String sqlUpdate = "UPDATE agencia SET cnpj=?, ie=?, im=?, razaosocial=?, nomefantasia=? WHERE idagencia=?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getCnpj()); 
         stm.setInt(2, getIe());
         stm.setInt(3, getIm());
         stm.setString(4, getRazaoSocial());
         stm.setString(5, getNomeFantasia());
			stm.setInt(6, getIdAgencia());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
   public void carregar(Connection conn) {
		String sqlSelect = "SELECT cnpj, ie, im, razaosocial, nomefantasia FROM agencia WHERE idagencia = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getIdAgencia());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setCnpj(rs.getString(1));
               setIe(rs.getInt(2));
               setIm(rs.getInt(3));
               setRazaoSocial(rs.getString(4));
               setNomeFantasia(rs.getString(5));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
}
