# spring-jpa-projection

the jpa projection is used to select partial entity attribute that the client is really want to have, rather than the whole of it. 

## projection types

### interface based projection

Spring rely on the interface to create proxy to wrap an entity so as to modify the entity behaviours.

#### closed projection

a closed projection means using a method name exaclty match an attribute name.

a contrain: the closed projection interface is only used as an element type of a collection.

#### open projection 

A Open projection decorated with SpEL enables us to define interface methods with unmatched names and with return values re-computed at a runtime.




