namespace AplicacaoTeste;

public partial class MainPage : ContentPage
{
    // Substitua estes textos pelos nomes reais dos autores do aplicativo.
    // Adicione ou remova linhas conforme o número de integrantes.
    private static readonly string[] Autores =
    {
        "Luiz Felipe Gonçalves da Silva (CB3030539)",
        "Geovanna Barros de Assunção (CB303271X)"
    };

    private bool _exibindoAlerta;

    public MainPage()
    {
        InitializeComponent();
    }

    private async void OnOkClicked(object? sender, EventArgs e)
    {
        // A comparação é exata: diferencia maiúsculas e preserva espaços.
        bool autorizado = IdEntry.Text == "admin"
                       && SenhaEntry.Text == "senha@dmin";

        await MostrarAlertaAsync(
            autorizado ? "Login" : "Acesso negado",
            autorizado ? "Logou com sucesso!" : "Login não autorizado.");
    }

    private void OnLimparClicked(object? sender, EventArgs e)
    {
        IdEntry.Text = string.Empty;
        SenhaEntry.Text = string.Empty;
        IdEntry.CursorPosition = 0;
        IdEntry.SelectionLength = 0;

        // Devolve o foco após o processamento do toque/clique no botão.
        Dispatcher.Dispatch(() => IdEntry.Focus());
    }

    private async void OnCreditosClicked(object? sender, EventArgs e)
    {
        await MostrarAlertaAsync(
            "Créditos",
            "Autores do APP:\n\n" + string.Join("\n", Autores));
    }

    private async Task MostrarAlertaAsync(string titulo, string mensagem)
    {
        // Evita abrir várias mensagens se houver cliques rápidos.
        if (_exibindoAlerta)
            return;

        _exibindoAlerta = true;
        try
        {
            await DisplayAlert(titulo, mensagem, "OK");
        }
        finally
        {
            _exibindoAlerta = false;
        }
    }
}
