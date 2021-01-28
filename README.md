# spring-jpa-projection

the jpa projection is used to select partial entity attribute that the client is really want to have, rather than the whole of it. 

## projection types

### interface based projection

Spring rely on the interface to create proxy to wrap an entity so as to modify the entity behaviours.

#### closed projection

a closed projection means a method name exactly matches an attribute name.

a constrain: the closed projection interface is only used as an element type of a collection.

a closed project may carry out a nested projection, but it must root on the owner side, otherwise, on the inverse side, it doesn't have a reference to the external entity. 

#### open projection 

An open projection decorated with SpEL enables us to define interface methods with unmatched names and with return values re-computed at a runtime.

drawback: its query is created during the runtime, so Spring cannot optimize the query in the advance.

## class-based project

instead of defining interfaces and allowing Spring to create proxy around them, we may create our own classes to project from the root entity via the repository.

a constraint: the class overrides hashcode and equal; constructor parameter name must the same as the counterparts declared in the root entity. 

