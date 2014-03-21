package com.williapv.geo.dao;

import com.williapv.geo.representation.GeonameZip;
import com.williapv.geo.representation.State;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by paul on 3/21/14.
 */
public class StateMapper implements ResultSetMapper<State> {

    public State map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        State state = new State();
        state.setAbbr(r.getString("state_abbr"));
        state.setName(r.getString("state_name"));
        return state;

    }
}
