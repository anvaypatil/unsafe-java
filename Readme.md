Unsafe Experiments
==================

#This Project contains basic experiments showing usage of Unsafe.java

Class `sun.misc.Unsafe` consists of 105 methods. 
Below are the few important methods which can be found widely used in various frameworks and JDK internal libraries:

The API is categorised into below,

##Info API:
 Just returns some low-level memory information
> 
 * addressSize
 * pageSize

##Objects. 
  Provides methods for object and its fields manipulation.
>
* allocateInstance
* objectFieldOffset

##Classes. 
  Provides methods for classes and static fields manipulation.
>
* staticFieldOffset
* defineClass
* defineAnonymousClass
* ensureClassInitialized

##Arrays. 
  For arrays manipulation.
>
* arrayBaseOffset
* arrayIndexScale

##Synchronization. 
  Low level primitives for synchronization.
>
* monitorEnter
* tryMonitorEnter
* monitorExit
* compareAndSwapInt
* putOrderedInt

##Memory. 
  Direct memory access methods.
>
* allocateMemory
* copyMemory
* freeMemory
* getAddress
* getInt
* putInt