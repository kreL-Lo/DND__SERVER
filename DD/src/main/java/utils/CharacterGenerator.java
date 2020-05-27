package utils;

import models.*;
import models.Character;

import java.util.*;

public class CharacterGenerator {
    public static Character generateBarbarian(){
        SavingThrows barbarianSavingThrows = new SavingThrows(4, 1, 5, -1, 1, 0);
        Skills barbarianSkills = new Skills(1, 1, -1, 4, 0, -1, 1,
                2, -1, 1, -1, 3, 0, 0, -1, 1,
                1, 3);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("dwarven & common",
                "light & medium armor & shields", "simple & martial weapons", "gaming set, vehicles (land)",
                "perception & survival");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("battleaxa",4,2));
        attackAndSpellList.add(new AttackAndSpell("handaxe",4,2));
        String equipament = "insignia of rank\n" +
                "trophy from fallen enemy\n" +
                "gaming set\n" +
                "common clothes\n" +
                "pouch\n" +
                "\n" +
                "battleaxe\n" +
                "handaxe x2\n" +
                "javelins x4\n" +
                "explorer's pack: backpack, bedroll, mess kit, 10 torches, 10 days of rations, waterskin, 50 ft of hempen rope";
        String personalityTraits = "I’m haunted by memories o f war. I can’t get the images of violence out of my mind.\n" +
                "\n" +
                "I enjoy being strong and like breaking things.";
        String ideals = "Nation. My people are all that matter.";
        String bonds = "Those who fight beside me are those worth dying for.";
        String flaws = "My hatred of my enemies is blind and unreasoning.";
        String featureAndTraits = "ASI: +2 to CON & +1 to WIS\n" +
                "Speed: 25 ft (speed doesn't reduce because of wearing heavy armor)\n" +
                "Darkvision: 60 ft\n" +
                "Dwarven Resilience: advantage on poison saves & resistance to poison damage\n" +
                "Dwarven Combat Training: prof. in battleaxe, handaxe, light hammer & warhammer\n" +
                "Tool Proficiency: prof. in one artisan tools from: smith's tools, brewer's suppliers, or mason's tools.\n" +
                "Stonecunning: considered prof. in History (Intelligence) checks and double prof. related to stonework\n" +
                "Dwarven Toughness: +1 hit point per level\n" +
                "\n" +
                "Barbarian Class Features:\n" +
                "1st lvl: Rage ( 2 uses per long rest)\n" +
                "- to start or end rage cost bonus action\n" +
                "- rage lasts 1 minute\n" +
                "- advantage on STR saves & ability checks\n" +
                "- when making melee weapon attacks with STR, granted +2 on damage rolls\n" +
                "- have resistance to bludgeoning, piercing and slashing damage\n" +
                "\n" +
                "1st lvl: Unarmored Defense:\n" +
                "- AC = 10 + CON mod + DEX mod\n" +
                "- when not wearing armor, can use shield\n";
        Character barbarian = new Character(
                "Barbarian", "Soldier(Infantry)", "Shield(Hill) Dwarf", 0, 14,
                13, 17, 8, 13, 10, 13, 2, 14, 1,
                25, 16, attackAndSpellList, barbarianSavingThrows, barbarianSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return barbarian;
    }
    public static Character generateCleric(){
        SavingThrows clericSavingThrows = new SavingThrows(-1, 2, 1, 2, 5, 1);
        Skills clericSkills = new Skills(2, 3, 4, -1, 0, 4, 5,
                0, 2, 3, 2, 3, 0, 2, 4, 2,
                2, 3);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("common & 1 additional",
                "light & medium armor & shields", "simple weapons", "",
                "history & persuasion");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("mace",1,-1));
        attackAndSpellList.add(new AttackAndSpell("light crossbow",4,2));
        attackAndSpellList.add(new AttackAndSpell("spells",5,0));
        String equipament = "holy symbol\n" +
                "prayer book\n" +
                "5 sticks of incense\n" +
                "common clothes\n" +
                "pouch\n" +
                "\n" +
                "mace\n" +
                "scale mail\n" +
                "bolts x20\n" +
                "shield (holy symbol)\n" +
                "light crossbow\n" +
                "explorer's pack: backpack, bedroll, mess kit, 10 torches, 10 days of rations, waterskin, 50 ft of hempen rope";
        String personalityTraits = "I quote sacred texts and proverbs in almost every situation.\n" +
                "I've enjoyed fine food, drink, and high society among my temple’s elite. Rough living grates on me.\n" ;
        String ideals = "I seek to prove myself worthy of my god’s favor by matching my actions against his or her teachings.\n";
        String bonds = "I seek to preserve a sacred text that my enemies consider heretical and seek to destroy.";
        String flaws = "I put too much trust in those who wield power within my temple’s hierarchy.";
        String featureAndTraits = "ASI: +1 to all abilities\n" +
                "Speed: 30 ft\n" +
                "\n" +
                "Cleric Class Features:\n" +
                "1st lvl: Spellcasting\n" +
                "- cantrips: know 3 cantrips from cleric list\n" +
                "- prepare WIS mod + cleric lvl in spells\n" +
                "- know spells as per chart on pg 57 of PHB\n" +
                "- DC = 8 + prof. bonus + WIS mod\n" +
                "- ritual casting\n" +
                "- spellcasting focus: can use holy symbol\n" +
                "\n" +
                "1st lvl: Divine Domain (Arcana)\n" +
                "- domain spells: once you gain these you have them always prepared and they do not count against number you can prepare each day.\n" +
                "\n" +
                "1st lvl: Arcane initiate:\n" +
                "- prof. in arcana skill\n" +
                "- gain 2 cantrips from wizard spell list, these count as cleric cantrips for you";

        Character cleric = new Character(
                "Cleric", "Acolyte", "Human", 0, 9,
                15, 13, 14, 16, 11, 13, 2, 18, 2,
                30, 9, attackAndSpellList, clericSavingThrows, clericSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return cleric;
    }
    public static Character generateFighter(){
        SavingThrows fighterSavingThrows = new SavingThrows(2, 3, 5, 0, 0, 0);
        Skills fighterSkills = new Skills(5, 0, 0, 2, 0, 0, -2,
                0, 0, 0, 0, 0, 0, 2, 0, 3,
                3, 0);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("Common, Halfling, Elvish",
                "All Armor and Shields", "Simple & Martial Weapons", "Artisan Tool Proficiency",
                "");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("Scimitar",5,3));
        attackAndSpellList.add(new AttackAndSpell("S Sword",5,3));
        attackAndSpellList.add(new AttackAndSpell("L Xbow",5,3));
        String equipament = "Leather Armor, 1\n" +
                "Scimitar, Slashing, 3lb, Finesse, Light\n" +
                "Short Sword, Piercing, 2lb, Finesse, Light\n" +
                "Light Crossbow, Piercing, 80/320, Loading, Two-Handed\n" +
                "20 x Bolts\n" +
                "\n" +
                "Artisan Smith's Tools" +
                "Traveler's Clothes\n" +
                "Backpack\n" +
                "Crowbar & Hammer\n" +
                "10 x Pitons\n" +
                "10 x Torches\n" +
                "10 x Rations\n" +
                "Tinderbox\n" +
                "Waterskin\n" +
                "50 Foot Hemp Rope\n";
        String personalityTraits = "I like to talk at length about my profession\n" +
                "\n" +
                "Im well known for my work, and I want to make sure everyone appreciates it. Im always taken aback when people havent heard of me.";

        String ideals = "I work hard to be the best there is at my craft.\n";
        String bonds = "I owe my guild a great debt for forging me into the person I am today.";
        String flaws = "Im horribly jealous of anyone who can outshine my hadiwork. Everywhere I go, Im surrounded by rivals.";
        String featureAndTraits =
                "Lvl 1 - Fighting Style Two-Weapon Fighting, This allows you to add your modifier for the damage to your bonus off hand attack.\n" +
                        "Lvl 1 - Second Wind, Bonus Action, 1d10+Fighter lvl, Short or Long Rest";
        Character fighter = new Character(
                "Fighter", "Guild Artisan / Smith", "Halfling, Stout", 0, 11,
                17, 16, 10, 10, 10, 10, 2, 14, 3,
                25, 13, attackAndSpellList, fighterSavingThrows, fighterSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return fighter;
    }
    public static Character generatePaladin(){
        SavingThrows paladinSavingThrows = new SavingThrows(3, 0, 2, 1, 2, 4);
        Skills paladinSkills = new Skills(0, 0, 1, 3, 2, 1, 2,
                4, 1, 2, 1, 0, 2, 2, 3, 0,
                0, 0);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("Common, Dwarvish",
                "All Armor", "Simple & Martial Weapons", "Shields",
                "");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("Battleaxe",5,3));
        attackAndSpellList.add(new AttackAndSpell("Javelins",5,3));
        String equipament = "Battleaxe, slashing, Versatile, 4 lbs.\n" +
                "\n" +
                "5 x Javelin, Piecing, 30 / 120, 10 lbs.\n" +
                "\n" +
                "Chainmail, AC 16, 55 lbs.\n" +
                "\n" +
                "Shield, +2 AC, 6 lbs." +
                "\n" +
                "Prayer Book & Vestments\n" +
                "Common Clothed\n" +
                "Backpack\n" +
                "Blanket\n" +
                "10 x Candles\n" +
                "Tinderbox\n" +
                "Alms Box\n" +
                "2 x Blocks Insense\n" +
                "Waterskin\n" +
                "2 x Rations";
        String personalityTraits = "I idolize a particular hero of my faith, and constantly refer to that person's deads and examples.\n" +
                "I quote sacred texts and proverbs.";

        String ideals = "Tradition, The ancient traditions of worship and sacrifice must be preserved and upheld.\n";
        String bonds = "Everything I do is for the common people.";
        String flaws = "I judge others harshly, and myself even more severely";
        String featureAndTraits = "-Lvl 1, Divine Sense, Action, within 60 feet you know the location of any celestial, fiend or undead. You can use this 1 + Cha modifier. Long Rest.\n" +
                "-Lvl 1, Lay On Hands, Action, you have a healing pool paladin level x 5. " +
                "You can touch and heal HP or spend 5 points and cure disease or 1 poison effect.";
        Character paladin = new Character(
                "Paladin", "Acolyte", "Mountain Dwarf", 0, 16,
                10, 15, 12, 10, 14, 10, 2, 18, 0,
                25, 12, attackAndSpellList, paladinSavingThrows, paladinSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return paladin;
    }
    public static Character generateWarlock(){
        SavingThrows warlockSavingThrows = new SavingThrows(-1, -1, 0, 3, 5, 5);
        Skills warlockSkills = new Skills(4, 1, 0, 0, 5, 0, 3,
                5, 0, 3, 0, 1, 5, 3, 0, 4,
                2, 1);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("",
                "", "", "",
                "");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("E. Blast",5,3));
        String equipament = "Eldritch Blast - 120'/ VS/ 1 action/ instant - 1 target ranged spell attack for 1d10+3 Force damage\n" +
                " \n" +
                "Hex - 90'/ VSM/ 1 bonus/ con 1 hour - 1d6 Necrotic bonus damage on a successful attack, if target drops to 0HP you may use a bonus action on your turn to transfer the Hex to another target within range" +
                "\n" +
                "Body - Studded Leather (12AC+Dex)\n" +
                "RH - Quarterstaff\n" +
                "LH - Empty\n" +
                "Misc - Component Pouch, Herbalism Kit";
        String personalityTraits = "spiritual enlightenment\n" +
                "Trait - I connect everything that happens to me to a grand, cosmic plan.";

        String ideals = "If you know yourself, there's nothing left to know.\n";
        String bonds = "I am still seeking the enlightenment I pursued in my seclusion, and it still eludes me.";
        String flaws = "I like keeping secrets and won't share them with anyone.";
        String featureAndTraits = "--==Racial==-\n" +
                "***Race-Half-Elf***\n" +
                "*Ability Score - Charisma +2, Intelligence +1 and Wisdom +1\n" +
                "*Size - Medium\n" +
                "*Darkvision - Dim=Bright, Dark=Dim(no color in Dark)\n" +
                "*Fey Ancestry - Advantage vs. Charm effects and Immunity vs. Sleep\n" +
                "*Skill Versatility - Perception(Wis) and Persuasion(Cha)\n" +
                "*Languages - Common, Elvish and Sylvan\n" +
                " \n" +
                "--==Background==--\n" +
                "***Background - Hermit***\n" +
                "*Skills - Medicine(Wis) and Religion(Int)\n" +
                "*Tools - Herbalism Kit\n" +
                "*Languages - Primordial\n" +
                " \n" +
                "--==Class==--\n" +
                "***Class - Warlock***\n" +
                "*Hit Dice - 2d8\n" +
                "*Armor - Light\n" +
                "*Weapons - Simple\n" +
                "*Saving Throws - Wisdom and Charisma\n" +
                "*Skills - Arcana(Int) and Nature(Int)\n" +
                "*Starting Gold - 160GP (4d4x10)\n" +
                "  \n" +
                "--==Archetype==--\n" +
                "***Archetype - Patron(Fey)***\n" +
                "*Pact Magic - spell slots are of the same level and are refreshed with a short rest\n" +
                "*Fey Presence - creatures in a 10' cube originating from you must make a Wisdom save or become either Frightened or Charmed (your choice) until the end of your next turn; may use once per short or long rest\n" +
                " \n" +
                "--==Special==--\n" +
                "***Eldritch Invocations(2)***\n" +
                "*1 - Agonizing Blast - add Charisma modifier to Eldritch Blast damage on a successful hit\n" +
                "*2 - Misty Visions - you can cast \"Silent Image\" at will\n";
        Character warlock = new Character(
                "Warlock", "Hermit - Seeker", "Half-Elf", 300, 8,
                8, 10, 16, 16, 16, 15, 2, 11, -1,
                30, 13, attackAndSpellList, warlockSavingThrows, warlockSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return warlock;
    }
    public static Character generateBard(){
        SavingThrows bardSavingThrows = new SavingThrows(0, 4, 2, 0, 1, 5);
        Skills bardSkills = new Skills(1, 3, 5, -1, 3, 3, 3,
                3, 3, 3, 5, 5, 3, 5, 5, -1,
                -1, 3);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("Common, Elven, Halfling",
                "Light Armor", "Simple Weapons\n" +
                "Hand Crossbows, Longsword, Rapiers , Shortswords", "Lute, bagpipe, flute, cowbell",
                "Instrument Proficiencies");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("Rapier attack",4,3));
        attackAndSpellList.add(new AttackAndSpell("Dagger attack",4,3));
        String equipament = "Rapier,  2lb, Piercing, Finesse\n" +
                "\n" +
                "Dagger, 1 lb, Finesse, Light,  20/60\n" +
                "\n" +
                "Leather Armor, 11+Dex Mod, 10 lbs.\n" +
                "Lute, bagpipe, flute, cowbell \n"+
                "Disguise Kit\n" +
                "Backpack\n" +
                "Bedroll\n" +
                "2 x Costumes\n" +
                "5 x Candles\n" +
                "5 x Rations\n" +
                "Waterskin Disguise Kit";

        String personalityTraits = "I love a good insult, even one directed at me.\n" +
                "\n" +
                "I'll settle for nothing less than perfection.";

        String ideals = "Beauty - When I perform, I make the world better than it was.";
        String bonds = "I want to be famous, whatever it takes.";
        String flaws = "I'll do anything to win fame and renown.";
        String featureAndTraits = "Lvl 1, Bardic Inspiration, Bonus Action, You can cast this on another creature and it has to use it within 10 minutes. That player can add an additional 1d6 to an attack, save or skill check roll. Once this is used the player loses it.\n " +
                "The bard can use this feature the amount of times to the Bard's Cha modifier.\n" +
                "Long Rest to recover.\n" +
                "(5th 1d8), (10 1d10), (15 1d12)\n" +
                "Lvl 1 Class Skill Proficiencies: Deception, Insight, Medicine, -Entertainer background also gives Acrobatics and Performance. Race (Half Elf) gives you proficiency in another 2 skills, Intimidation and Sleight of Hand. ";
        Character bard = new Character(
                "bard", "Entertainer / Singer", "Half-Elf", 0, 10,
                14, 14, 10, 12, 17, 11, 2, 13, 2,
                30, 10, attackAndSpellList, bardSavingThrows, bardSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return bard;
    }

    public static Character generateRogue(){
        SavingThrows rogueSavingThrows = new SavingThrows(1, 5, 0, 3, 1, 2);
        Skills rogueSkills = new Skills(3, 1, 1, 3, 4, 1, 1,
                2, 3, 1, 1, 3, 2, 2, 1, 5,
                5, 1);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("Common, Elvish and Undercommon",
                "Light Armor", "Simple weapons, Hand crossbows, longswords, rapiers, shortswords, shortbows and longbows.", "Disguise kit and Forgery kit.",
                "Proficient w/ Thieves' Tools");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("Sword attack",5,3));
        attackAndSpellList.add(new AttackAndSpell("Shortblow attack",5,3));
        String equipament = "Shortsword, Piercing, Light, Finesse, 2 lb, One-Handed.\n" +
                "\n" +
                "Shortbow, Piercing, 2 lb, 80/32\n"+
                "Leather Armour 11+Dex AC 10 lbs\n" +
                "Backpack\n" +
                "1000 x Ball Bearings\n" +
                "10 ft String\n" +
                "Bell\n" +
                "5 x Candles\n" +
                "Crowbar\n" +
                "Hammer\n" +
                "10 x Pitons\n" +
                "Hooded Lantern\n" +
                "2 x Flasks of Oil\n" +
                "5 x Rations\n" +
                "Tinderbox\n" +
                "Waterskin\n" +
                "Bedroll\n" +
                "Quiver\n" +
                "20 x Arrows\n" +
                "Fine clothing Disguise kit\n" +
                "Wheigted Dice\n" +
                "Belt Pouch\n" +
                "Theives' Tools";

        String personalityTraits = "Favourite Scheme; \"I cheat at games of chance\".\n" +
                "Flattery is my preferred trick for getting what I want.\n" +
                "I lie about almost everything, even when there's no good reason to.";

        String ideals = "Friendship. Materials come and go. Bonds of friendship last forever. (Good)";
        String bonds = "I swindeled and ruined a person who didn't deserve it. I seek to atone for my misdeeds but might never be able to forgive myself";
        String flaws = "I hate to admit it and will hate myself for it, but i'll run and preserve my own hide if the going gets tough";
        String featureAndTraits = "Expertise; Theives' Tools and Sleight of Hand,Sneak Attack";
        Character rogue = new Character(
                "rogue", "Charlatan", "Half-Elf", 0, 12,
                16, 10, 12, 12, 14, 3, 2, 14, 3,
                30, 8, attackAndSpellList, rogueSavingThrows, rogueSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return rogue;
    }
    public static Character generateKnight(){
        SavingThrows knightSavingThrows = new SavingThrows(2, 3, 4, -1, 1, 2);
        Skills knightSkills = new Skills(3, 1, -1, 2, 2, 1, 1,
                2, -1, 1, 1, 3, 2, 4, -1, 3,
                3, 1);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("common & 1 additional",
                "all armor & shields", "simple & martial weapons", "1 gaming set",
                "athletics & perception");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("Rapier attack",5,3));
        attackAndSpellList.add(new AttackAndSpell("Longbow attack",5,3));
        String equipament = "Background Equipment:\n" +
                "set of fine clothes\n" +
                "signet ring\n" +
                "scroll of pedigree\n" +
                "purse\n" +
                "\n" +
                "Class Equipment:\n" +
                "scale mail\n" +
                "longbow\n" +
                "arrows x20\n" +
                "rapier\n" +
                "shield\n" +
                "explorer's pack: backpack, bedroll, mess kit, 10 torches, 10 days of rations, waterskin, 50 ft of hempen rope";


        String personalityTraits = "I don’t like to get my hands dirty, and I won’t be caught dead in unsuitable accommodations.\n" +
                "\n" +
                "My favor, once lost, is lost forever.";

        String ideals = "Responsibility. It is my duty to respect the authority of those above me, just as those below me must respect mine. (Lawful)";

        String bonds = "My loyalty to my sovereign is unwavering.";
        String flaws = "I too often hear veiled insults and threats in every word addressed to me, and I’m quick to anger.";
        String featureAndTraits = "Human Variant Traits:\n" +
                "ASI: +1 to DEX & CHR\n" +
                "Feat: Inspiring Leader: up to 6 friendly creatures within 30 ft that can hear or see you gain temp hit points equal to your level + CHR mod\n" +
                "- gain this bonus only once per short or long rest\n" +
                "\n" +
                "Fighter Class Features:\n" +
                "1st lvl: Fighting Style (Defense)\n" +
                "- +1 to AC if wearing armor\n" +
                "\n" +
                "1st lvl: Second Wind: - as a bonus action, regain hit points equal to 1d10+fighter level\n" +
                "- 1 use per short or long rest";
        Character knight = new Character(
                "knight", "Noble (Knight)", "Human (Variant)", 0, 10,
                16, 14, 8, 12, 14, 13, 2, 19, 3,
                30, 12, attackAndSpellList, knightSavingThrows, knightSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return knight;
    }





}
