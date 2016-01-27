package sa41.ca.uno.CreateGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import sa41.ca.uno.LogInOut.Member;
import sa41.ca.uno.groupException;

@Stateless
public class GroupBean {

	private static final String INSERT_GROUP = "insert into groups values (?, ?)";
	private static final String INSERT_MEMBER = "insert into member values (?, ?, ?, ?)";

	@Resource(lookup = "jdbc/caUno") DataSource ds;

	@PostConstruct
	private void init() {
		System.out.println(">>> GroupBean created");
	}

	@PreDestroy
	private void cleanup() {
		System.out.println(">>> clean up");
	}

	//Transaction - begins
	public void createGroup(Groups grp) throws SQLException, groupException  {
		try (Connection conn = ds.getConnection()) {
			//auto-commit
			//conn.setAutoCommit(false);
			try {
				//Create group
				PreparedStatement ps = conn.prepareStatement(INSERT_GROUP);
				ps.setString(1, grp.getName());
				ps.setString(2, grp.getName());
				ps.executeUpdate();

				int i = 0;
				for (Member m : grp.getMembers()) {
					if (i++ > 1)
						throw new SQLException("Fake exception");
					ps = conn.prepareStatement(INSERT_MEMBER);
					ps.setString(1, m.getName());
					ps.setString(2, m.getEmail());
                                        ps.setString(3, m.getPassword());
					ps.setString(4, m.getGroupid());
					ps.executeUpdate();
				}
				//conn.commit(); //NOt necessary
			} catch (SQLException ex) {
				System.out.println(">>> will roll back");
				throw new NullPointerException("Fake exception NPE");
				///throw new SAGroupException(ex.getMessage());
				//conn.rollback();
				//throw ex;
			}

		}
	}
	//Tranaction ends - depends

}
