# Siren

<h3 align="center">
   
  [![Hits-of-Code](https://hitsofcode.com/github/deniszhukovski/Siren?branch=main)](https://hitsofcode.com/github/deniszhukovski/Siren/view?branch=main)
  [![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=DenisZhukovski_Siren&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=DenisZhukovski_Siren)
  [![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
 <!-- [![PDD status](https://www.0pdd.com/svg?name=deniszhukovski/webrequest.elegant)](https://www.0pdd.com/p?name=deniszhukovski/webrequest.elegant) -->
</h3>

Siren AI Music Player is an intuitive tempo-based music library, which through the use of intelligent learning, delivers mood-based tunes to listeners.

 ![Alt text](docs/Siren.Context.png?raw=true "Sirent Context")

# Major Components

 ![Alt text](docs/Siren.Container.png?raw=true "Sirent Software System")

 # Siren AI

The main goal is to generate audio track based on user audio profile. Music player passes user's profile which consists of genre preferences time of the day, preffered genres etc. Based on user's profile Siren AI should generate relevant audio track to support the mood. Ideally the track should seamlessly play the next song once the current is going to finish.

![Alt text](docs/Siren.DJ.Component.png?raw=true "Sirent Software System")

- [Harmony mixing](docs/Harmony%20mixing.md)
- [Beat-matching](docs/Beat-matching%20algo.md)

# Siren Shuffling

Siren shuffling should generate the play list based on user audio profile. It takes into consideration client's type, time of the day, preffered genres etc. Based on user's profile Siren AI should generate relevant playlist to support the mood.

![Alt text](docs/Siren.SmatrShuffling.Component.png?raw=true "Sirent Smart Shuffling Tracks")

- [Shuffling](docs/Shuffling.md)
- [Music Scheduling](docs/Music%20Scheduling.md)

## Build status

<div align="center">
  
   [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=DenisZhukovski_Siren&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=DenisZhukovski_Siren)
   [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=DenisZhukovski_Siren&metric=coverage)](https://sonarcloud.io/summary/new_code?id=DenisZhukovski_Siren)
   [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=DenisZhukovski_Siren&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=DenisZhukovski_Siren)
   [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=DenisZhukovski_Siren&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=DenisZhukovski_Siren)
</div>
