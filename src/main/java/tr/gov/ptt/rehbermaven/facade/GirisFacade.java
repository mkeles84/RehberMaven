/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.rehbermaven.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.rehbermaven.entity.Giris;

/**
 *
 * @author BEM
 */
@Stateless
public class GirisFacade extends AbstractFacade<Giris> {
    @PersistenceContext(unitName = "rehbermavenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }
    
    public boolean girisKontrol(Giris p_giris)
    {
        
        Giris giris = em.createNamedQuery("Giris.girisKontrol",Giris.class)
                .setParameter("kullanici", p_giris.getKullanici())
                .setParameter("sifre", p_giris.getSifre())
                .getSingleResult();
        
        if (giris != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
