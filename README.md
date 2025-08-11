<div align="center">

# Java Interview Notes

</div>

## Table of Contents
1. [Volatile Keyword](#volatile-keyword)
2. [Singleton Pattern](#singleton-pattern)
3. [Builder Pattern](#builder-pattern)

---

<div align="center">

## Volatile Keyword

</div>

```
┌────────────────────────────────────────────────────────────┐
│                    MAIN MEMORY (RAM)                       │
│  ┌──────────────────────────────────────────────────────┐  │
│  │             HEAP (Shared by all threads)             │  │
│  │  ┌─────────────┐  ┌─────────────┐  ┌─────────────┐   │  │
│  │  │   Object 1  │  │   Object 2  │  │ Static vars │   │  │
│  │  │             │  │             │  │             │   │  │
│  │  └─────────────┘  └─────────────┘  └─────────────┘   │  │
│  └──────────────────────────────────────────────────────┘  │
└────────────────────────────────────────────────────────────┘
                              ↑
                    Both threads share this
                              ↓
┌──────────────────┐                      ┌──────────────────┐
│    THREAD 1      │                      │    THREAD 2      │
│ ┌──────────────┐ │                      │ ┌──────────────┐ │
│ │ CPU Cache L1 │ │                      │ │ CPU Cache L1 │ │
│ │              │ │                      │ │              │ │
│ └──────────────┘ │                      │ └──────────────┘ │
│ ┌──────────────┐ │                      │ ┌──────────────┐ │
│ │ Stack Memory │ │                      │ │ Stack Memory │ │
│ │ (local vars) │ │                      │ │ (local vars) │ │
│ └──────────────┘ │                      │ └──────────────┘ │
└──────────────────┘                      └──────────────────┘
```

### Timeline Example

```
Time 1: Main Memory: counter = 0
        Thread 1 Cache: counter = 0
        Thread 2 Cache: counter = 0

Time 2: Thread 1 increments counter
        Thread 1 Cache: counter = 1  ← Updated in cache
        Main Memory: counter = 0     ← Not updated yet!
        Thread 2 Cache: counter = 0  ← Still old value

Time 3: Thread 2 reads counter
        Reads from its cache: counter = 0  ← Wrong value!
```

---

<div align="center">

## Singleton Pattern

</div>

**Step 1: Private Constructor**
```java
private ClassName() { }
```

**Step 2: Static Instance Variable**
```java
private static volatile ClassName instance = null;
```

**Step 3: Public Static Method (Double-Checked Locking)**
```java
public static ClassName getInstance() {
    if (instance == null) {                    // First check
        synchronized (ClassName.class) {       // Lock
            if (instance == null) {            // Second check
                instance = new ClassName();    // Create
            }
        }
    }
    return instance;
}
```

### Memory Checklist

✅ **Private constructor** - prevents external instantiation  
✅ **Static instance** - shared across all calls  
✅ **Volatile keyword** - ensures thread visibility  
✅ **Double-checked locking** - performance + thread safety  
✅ **Synchronized block** - prevents multiple creation

---

<div align="center">

## Builder Pattern

</div>

**Step 1: Create Builder Object**
```java
StudentBuilder builder = Student.getBuilder();
// OR
StudentBuilder builder = new StudentBuilder();
```

**Step 2: Set Data to Variables in Builder**
```java
builder.setName("Akash")
       .setAge(20)
       .setEmail("akash@gmail.com")
       .setPsp(85.5f);
```

**Step 3: Get the Original Class Object**
```java
Student student = builder.build();
```

### Complete Flow (Method Chaining)
```java
Student student = Student.getBuilder()
                    .setName("Akash")
                    .setAge(20)
                    .setEmail("akash@gmail.com")
                    .setPsp(85.5f)
                    .build();
```

### Implementation Checklist

✅ **Builder class** - holds temporary data  
✅ **Setter methods** - return `this` for chaining  
✅ **build() method** - creates final object  
✅ **Validation** - in main class constructor  
✅ **Static getBuilder()** - factory method for builder

### Key Benefits

- **Flexible object creation** with optional parameters
- **Method chaining** for clean syntax
- **Validation** in one place (main constructor)
- **Immutable** final object
- **Readable code** for complex objects