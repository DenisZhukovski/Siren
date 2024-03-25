workspace {

    model {
        user = person "User"
        admin = person "Admin"
        softwareSystem = softwareSystem "Siren" "All your musical sources in one place" {
            musicPlayer = container "Music Player" "Cross platform audio player" {
                user -> this "Uses to listen the music"
            }
            
            sirenAI = container "Siren AI" "Generates audio track that fits user's audio profile expectations at proper time of the day" {
                // musicPlayer -> this "Reads the tacks to play"
                sirenTrack = component "Siren Track" "AI generated to match player audio profile expectations" {
                    musicPlayer -> this "Reads the tack to play (passing audio profile)"
                }
                
                beatMatchbox = component "Beat-Matchbox" "“pitch shifting” an upcoming track to match its tempo" {
                    sirenTrack -> this "Uses to beat match the next track with the current"
                }
                harmonicMixer = component "Harmonic Mixer" "Creates more harmonic and melodic mix between songs" {
                    sirenTrack -> this "Uses to mix the next with the current track"
                }
            }
            sirenShufflingTracks = container "Siren shuffling" "Remembers what songs been played and learn to shuffle not on hours but on days, weeks, months" {
                sirenShufflingTracksComponent = component "Siren shuffling tracks" "Playlist to create best audio experience" {
                    sirenTrack -> this "Gets next track to play (passing audio profile)"
                }
                alreadyPlayedTracks = component "AlreadyPlayedTracks" "Tracks that been recenlty played for this client" {
                    sirenShufflingTracksComponent -> this "Reads tracks metadata that been played"
                }
                timeOfTheDayTracks = component "Time of the day tracks" "Filters the tracks which appropriate for requested time of the day" {
                    sirenShufflingTracksComponent -> this "Chooses one of the tracks""
                }
                tempoTracks = component "Tempo tracks" "Tracks that fit specific tempo" {
                    sirenShufflingTracksComponent -> this "Reads tracks for specific tempo"
                    timeOfTheDayTracks -> this "Reads tracks for specific genre"
                }
                genreTracks = component "Genre tracks" "Tracks that fit specific genre" {
                    tempoTracks -> this "Reads tracks for specific genre"
                    sirenShufflingTracksComponent -> this "Reads tracks for specific genre"
                    timeOfTheDayTracks -> this "Reads tracks for specific genre"
                }
            }
            profileManager = container "Audio Profiles" "Contains all the information which useful to generate proper audio track for the user" {
                musicPlayer -> this "Reads user's audio profile"
                admin -> this "Manages users' profiles to meet audio expectations"
            }
            musicStore = container "Music Store" "Audio tracks agregator, contains information for all audio tracks available in Siren" {
                sirenAI -> this "Reads tracks and metadata"
                sirenTrack -> this "Reads audio track stream"
                genreTracks -> this "Reads tracks metadata for specific genre"
                tempoTracks -> this "Reads tracks metadata for specifi tempo"
            }
            container "Track Metadata Database" {
                musicStore -> this "Reads from and writes to"
            }
        }
        appleMusic = softwareSystem "Apple Music" "Apple Music is an audio and video streaming service. Users select music to stream to their device on-demand, or they can listen to existing playlists. " {
           profileManager -> this "Uses for tracklist generation"
        }
        spotify = softwareSystem "Spotify" "Spotify offers digital copyright restricted recorded audio content, including more than 100 million songs and five million podcasts, from record labels and media companies." {
           profileManager -> this "Uses for tracklist generation"
        }
        soundtrackYourBrand = softwareSystem "Soundtrack Your Brand" "Background music for businesses that want it all (https://www.soundtrackyourbrand.com)" {
           musicStore -> this "Reads metadata and audio blobs"
        }
    }

    views {
        systemContext softwareSystem {
            include *
            autolayout lr
        }

        container softwareSystem {
            include *
            autolayout lr
        }
        
        component sirenAI {
            include *
            autolayout lr
        }
        
        component sirenShufflingTracks {
            include *
            autolayout lr
        }

        theme default
    }
}