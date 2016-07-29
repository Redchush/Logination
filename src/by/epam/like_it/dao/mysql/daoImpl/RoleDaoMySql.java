package by.epam.like_it.dao.mysql.daoImpl;

import by.epam.like_it.dao.Criteria;
import by.epam.like_it.dao.RoleDao;
import by.epam.like_it.dao.exception.DaoException;
import by.epam.like_it.dao.mysql.criteriaImpl.CriteriaMySql;
import by.epam.like_it.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RoleDaoMySql extends AbstractDaoMySql<Role>
        implements RoleDao {

    public RoleDaoMySql() {}

    public RoleDaoMySql(Connection connection) {
        super(connection);
    }

    @Override
    public List<Role> findAll() throws DaoException {
        return super.findAll();
    }

    @Override
    public Role findEntityById(int id) throws DaoException {
        return super.findEntityById(id);
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return super.delete(id);
    }

    @Override
    public boolean delete(Role entity) throws DaoException {
        return super.delete(entity);
    }

    @Override
    public boolean create(Role entity) throws DaoException {
        return super.create(entity);
    }

    @Override
    public Role update(Role entity) throws DaoException {
        return super.update(entity);
    }

    @Override
    protected List<Role> createEntityList(ResultSet set) throws SQLException {
        List<Role> entities = new ArrayList<>();
        while (set.next()) {
            int id = set.getInt(1);
            String name = set.getString("name");
            Role entity = new Role(id, name);
            entities.add(entity);
        }
        return entities;
    }

    @Override
    protected void fillStatementWithFullAttributesSet(PreparedStatement statement, Role entity, int from)
            throws SQLException {
        String name = entity.getName();
        statement.setString(1, name);
    }

    @Override
    protected Class<Role> getGenericType() {
        return Role.class;
    }

    @Override
    public Criteria<Role> getCriteria() {
        return new CriteriaMySql<Role>(Role.class);
    }


}



//roles.1 = id
//        roles.2 = name