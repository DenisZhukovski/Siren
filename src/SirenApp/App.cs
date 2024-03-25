using Microsoft.Extensions.Hosting;
using Microsoft.UI.Dispatching;
using Siren.Extensions;

namespace Siren;

public class App : Application
{
    protected Window? MainWindow { get; private set; }

    protected IHost? Host { get; private set; }
    
    protected override async void OnLaunched(LaunchActivatedEventArgs args)
    {
#if __IOS__ || __ANDROID__
        FeatureConfiguration.Style.ConfigureNativeFrameNavigation();
#endif
        var builder = this.CreateBuilder(args)
            .Configure(host => host
#if DEBUG
                .UseEnvironment(Environments.Development)
#endif
                .ConfigureServices(RegisterServices)
                .UseNavigation(
                    RegisterRoutes,
                    configure: cfg => cfg with { AddressBarUpdateEnabled = true }
                )
            ).UseToolkitNavigation();
        MainWindow = builder.Window;
#if DEBUG
        MainWindow.EnableHotReload();
#endif
        Host = await MainWindow.InitializeNavigationAsync(
            () => Task.FromResult(builder.Build()),
            initialNavigate: (sp, nav) => DispatcherQueue
                .GetForCurrentThread()
                .OnUIAsync(() => _ = nav.NavigateViewModelAsync<MainViewModel>(this))
        );
    }

    private static void RegisterServices(HostBuilderContext context, IServiceCollection services)
    {
        // Nothing
    }
    
    private static void RegisterRoutes(IViewRegistry views, IRouteRegistry routes)
    {
        views.Register(
            new ViewMap<MainPage, MainViewModel>()
        );
    }
}
