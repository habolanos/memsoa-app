/**
 * 
 */
package org.memsoa.app.dao.impl;

import org.memsoa.app.dao.PersonaDao;
import org.memsoa.app.dao.base.AbstractDaoImpl;
import org.memsoa.app.model.Persona;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-dao
 * @class PersonaDaoImpl
 * @date 16/07/2013
 *
 */
@Repository
public class PersonaDaoImpl extends AbstractDaoImpl<Persona, String> implements PersonaDao{

}
