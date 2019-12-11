/**.
* Info about this package doing something for package-info.java file.
*/
package com.bootcamp.microservicePerson.microServicePerson.repository;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import java.util.Date;

import com.bootcamp.microservicePerson.microServicePerson.models.dto.PersonDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**.
 * Esta en la injeccion de nuestro Respository
 */
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
  /**.
 * Esta en la injeccion de nuestro Respository
 * @param names ""
 * @return Flux
 */
  Flux<Person> findBynamePerson(String names);
  
  /**.
 * 'Esta en la injeccion de nuestro Respository'
 * @param numDoc ""
 * @return Flux
 */
  Mono<Person> findBynumDoc(String numDoc);

  /**.
 * Esta en la injeccion de nuestro Respository
 * @param firstDate new Date()
 * @param lastDate new Date()
 * @return Flux
 */
  Flux<Person> findBydateBirth(Date firstDate, Date lastDate);
}
