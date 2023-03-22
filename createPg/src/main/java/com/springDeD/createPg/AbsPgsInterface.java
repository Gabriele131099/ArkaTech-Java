package com.springDeD.createPg;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class AbsPgsInterface implements PgRepository {


    @Override
    public Optional<Pg> findByPgname(String Pgname) {
        return Optional.empty ( );
    }

    @Override
    public Optional<Pg> findByEmail(String email) {
        return Optional.empty ( );
    }

    @Override
    public boolean existsByPgname(String Pgname) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Pg> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Pg> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Pg> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pg getOne(Long aLong) {
        return null;
    }

    @Override
    public Pg getById(Long aLong) {
        return null;
    }

    @Override
    public Pg getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Pg> Optional<S> findOne(Example<S> example) {
        return Optional.empty ( );
    }

    @Override
    public <S extends Pg> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Pg> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Pg> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Pg> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Pg> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Pg, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Pg> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Pg> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Pg> findById(Long aLong) {
        return Optional.empty ( );
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }


    @Override
    public List<Pg> findAll() {
        List<Pg> PgList = new ArrayList<> ();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnddb", "root", "Vivident.root");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pg");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Pg Pg = new Pg();
                Pg.setId (resultSet.getLong ("Id"));
                Pg.setUserId (resultSet.getLong ("IDuser"));
                Pg.setCharacterName(resultSet.getString("CharacterName"));
                Pg.setRace(resultSet.getString("Race"));
                Pg.setClassLevel(resultSet.getInt("ClassLevel"));

              

                PgList.add(Pg);
            }

        } catch ( SQLException e) {

        }

        return PgList;
    }

    @Override
    public List<Pg> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Pg entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Pg> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Pg> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Pg> findAll(Pageable pageable) {
        return null;
    }
}

