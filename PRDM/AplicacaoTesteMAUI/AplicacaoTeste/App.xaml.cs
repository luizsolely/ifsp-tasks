namespace AplicacaoTeste;

public partial class App : Application
{
    public App()
    {
        InitializeComponent();
        UserAppTheme = AppTheme.Dark;
    }

    protected override Window CreateWindow(IActivationState? activationState)
    {
        var window = new Window(new MainPage())
        {
            Title = "Aplicação Teste"
        };

#if WINDOWS || MACCATALYST
        window.Width = 420;
        window.Height = 720;
        window.MinimumWidth = 320;
        window.MinimumHeight = 480;
#endif

        return window;
    }
}
