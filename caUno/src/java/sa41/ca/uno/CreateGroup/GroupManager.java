package sa41.ca.uno.CreateGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import sa41.ca.uno.LogInOut.Member;

public class GroupManager {

	private static final String INSERT_GROUP = "insert into groups values (?, ?)";
	private static final String INSERT_MEMBER = "insert into member values (?, ?, ?, ?)";

	private final DataSource ds;

	public GroupManager(DataSource d) {
		ds = d;
	}

	public void createGroup(Groups grp) throws SQLException {
		try (Connection conn = ds.getConnection()) {
			//auto-commit
			conn.setAutoCommit(false);
			try {
				//Create group
				PreparedStatement ps = conn.prepareStatement(INSERT_GROUP);
				ps.setString(1, grp.getName());
				ps.setString(2, grp.getName());
				ps.executeUpdate();

				int i = 0;
				for (Member m : grp.getMembers()) {
					
					ps = conn.prepareStatement(INSERT_MEMBER);
					
					ps.setString(1, m.getName());
					ps.setString(2, m.getEmail());
                                        ps.setString(3, m.getPassword());
					ps.setString(4, m.getGroupid());
					ps.executeUpdate();
				}
				conn.commit(); //NOt necessary
			} catch (SQLException ex) {
				System.out.println(">>> will roll back");
				conn.rollback();
				throw ex;
			}

		}
	}

}
