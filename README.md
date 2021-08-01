# ProjectEX

This is port of Project EX by [LatvianModder](https://github.com/LatvianModder). I have not created any part of this mod, only adapted it to work with minecraft 1.16

[Original mod curseforge page](https://www.curseforge.com/minecraft/mc-mods/project-ex)  
[Original mod repository](https://github.com/LatvianModder/Project-EX)

This mod is addon for [ProjectE](https://www.curseforge.com/minecraft/mc-mods/projecte) mod and requires it to work

---

## Details

As though, goal of this port is to be close to the original mod, I am trying to follow modern guidelines and how other modders do things (namely ProjectE and Create devs). Given this, I may alter mod structure to suit better this approach

I am no guru in modding (opposite, actually), and have never touched modding before 1.16. Despite, I'll still try to analyze what changed since 1.12 (using ProjectE as example) and try to explain my design choices

---

## Notes

I'll put here notable things I encountered during my work. For more insights - see comments (I try to leave detailed comments on what I have written and why)

### ItemGroup

CreativeTab is now ItemGroup. It's set via `Properties` argument to item constructor

### Deferred Registers

This is new (?) way of registering items, blocks, recipes etc. Can be used instead of handling `RegistryEvent.Register<Stuff>` event. Pretty sure latter still works. I assume being assigned even bus, it just waits for the same event and then registers whatever was supplied to it before

### Flattening

Since subtypes were removed, assets structure should be flat. Currently, changed only `matter/<color>` to `<color>_matter` in models. Will have to address other blocks later. Probably will have to use _DataGen_

--- 

## TODO

Incomplete roadmap for mod

- [ ] Registries
  - [x] Items
  - [ ] Blocks
  - [ ] Tile Entities
  - [ ] Recipes
- [ ] Items
  - [x] Matter
  - [ ] Stars
  - [ ] Block Items
    - [ ] Tables
    - [ ] Links
    - [ ] Collectors
    - [ ] Relays
    - [ ] Power Flowers
  - [ ] Knowledge sharing Book
  - [ ] Arcane Tablet
- [ ] Blocks
  - [ ] Tables
  - [ ] Links
  - [ ] Collectors
  - [ ] Relays
  - [ ] Power Flowers
- [ ] Tile Entities
  - [ ] Tables
  - [ ] Links
  - [ ] Collectors
  - [ ] Relays
  - [ ] Flowers
- [ ] Recipes
  - [ ] Matter
  - [ ] Stars
  - [ ] Block Items
      - [ ] Tables
      - [ ] Links
      - [ ] Collectors
      - [ ] Relays
      - [ ] Power Flowers
  - [ ] Knowledge sharing Book
  - [ ] Arcane Tablet
  - [ ] Gui
- [ ] Configs
- [ ] Network
- [ ] Language
- [ ] Other
  - [ ] Creative tab _(wrong icon for now)_
