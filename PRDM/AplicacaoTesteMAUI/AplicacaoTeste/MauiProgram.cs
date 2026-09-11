using Microsoft.Maui.Handlers;

namespace AplicacaoTeste;

public static class MauiProgram
{
    public static MauiApp CreateMauiApp()
    {
        var builder = MauiApp.CreateBuilder();
        builder.UseMauiApp<App>();

        // O contorno branco é desenhado pelo Border do XAML.
        // Removemos o contorno nativo para manter o visual do protótipo.
        EntryHandler.Mapper.AppendToMapping("CamposDoPrototipo", (handler, view) =>
        {
#if ANDROID
            handler.PlatformView.Background = null;
#elif IOS || MACCATALYST
            handler.PlatformView.BorderStyle = UIKit.UITextBorderStyle.None;
#elif WINDOWS
            handler.PlatformView.BorderThickness = new Microsoft.UI.Xaml.Thickness(0);
            handler.PlatformView.Padding = new Microsoft.UI.Xaml.Thickness(0);
#endif
        });

        return builder.Build();
    }
}
