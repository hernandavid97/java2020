package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Localidad;
import entities.Mascota;
import entities.Vacuna;

public class DataVacuna {

	public ArrayList<Vacuna> getAll() {
		ArrayList<Vacuna> vacunas = new ArrayList<Vacuna>();
		try {
			String consulta = "select * from vacuna";
			PreparedStatement stmt = DbConnector.getInstancia().getConn().prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vacuna v = new Vacuna();

				v.setId(rs.getInt("id_vacuna"));
				v.setTitulo(rs.getString("titulo"));
				v.setEspecie(rs.getString("especie"));
				v.setDescripcion(rs.getString("descripcion"));

				vacunas.add(v);
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			DbConnector.getInstancia().releaseConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacunas;
	}

	public int altaVacuna(Vacuna v) {
		int id = -1;
		try {

			String consulta = "insert into vacuna (titulo,especie,descripcion) values (?,?,?)";
			PreparedStatement stmt = DbConnector.getInstancia().getConn().prepareStatement(consulta,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, v.getTitulo());
			stmt.setString(2, v.getEspecie());
			stmt.setString(3, v.getDescripcion());

			stmt.executeUpdate();
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException("Creating vacuna failed, no ID obtained.");
				}
			}

			if (stmt != null) {
				stmt.close();
			}
			DbConnector.getInstancia().releaseConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public Vacuna getById(int id_vacuna) {
		Vacuna v = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select id_vacuna,titulo,especie,descripcion from vacuna where id_vacuna=?");
			stmt.setInt(1, id_vacuna);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				v = new Vacuna();
				v.setId(rs.getInt("id_vacuna"));
				v.setTitulo(rs.getString("titulo"));
				v.setEspecie(rs.getString("especie"));
				v.setDescripcion(rs.getString("descripcion"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return v;
	}
}
