using System;
using Windows.Media.Core;

namespace Siren;

public sealed partial class MainPage : Page
{
    public MainPage()
    {
        this.InitializeComponent();
    }

    protected override void OnNavigatedTo(NavigationEventArgs e)
    {
        base.OnNavigatedTo(e);
        
        AudioPlayer.MediaPlayer.Source = MediaSource.CreateFromUri(
            new Uri("https://uno-assets.platform.uno/tests/audio/Getting_Started_with_Uno_Platform_and_Visual_Studio_Code.mp3")
        );
        // AudioPlayer.MediaPlayer.SetStreamSource(
        //     MediaSource.CreateFromMediaStreamSource(mediaStreamSource).MediaStreamSource
        // );
    }
}
