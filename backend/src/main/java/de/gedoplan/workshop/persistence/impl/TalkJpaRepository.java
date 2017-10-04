package de.gedoplan.workshop.persistence.impl;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class TalkJpaRepository implements TalkRepository {

  @Inject
  EntityManager entityManager;

  @Override
  public void persist(Talk talk) {
    this.entityManager.persist(talk);
  }

  @Override
  public Talk merge(Talk talk) {
    return this.entityManager.merge(talk);
  }

  @Override
  public void remove(Talk talk) {
    this.entityManager.remove(talk);
  }

  @Override
  public Talk findById(Integer id) {
    return this.entityManager.find(Talk.class, id);
  }

  @Override
  public List<Talk> findAll() {
    return this.entityManager.createQuery("select x from Talk x", Talk.class).getResultList();
  }
}
