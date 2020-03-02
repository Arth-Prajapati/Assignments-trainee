using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using To_Do.Model;
using Xamarin.Forms;

namespace To_Do
{
    // Learn more about making custom code visible in the Xamarin.Forms previewer
    // by visiting https://aka.ms/xamarinforms-previewer
    [DesignTimeVisible(false)]
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

     


        protected override void OnAppearing()
        {
            base.OnAppearing();

            var notes = new List<Notes>();

            var files = Directory.EnumerateFiles(App.FolderPath, "*.notes.txt");
            foreach (var filename in files)
            {
                notes.Add(new Notes
                {
                    Filename = filename,
                    Text = File.ReadAllText(filename),
                    time = File.GetCreationTime(filename)
                });
            }

            listView.ItemsSource = notes
                .OrderBy(d => d.time)
                .ToList();
        }

        async void Button_Clicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new Page1
            {
                BindingContext = new Notes()
            });
        }

        async void OnListViewItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            if (e.SelectedItem != null)
            {
                await Navigation.PushAsync(new Page1
                {
                    BindingContext = e.SelectedItem as Notes
                });
            }
        }


    }
}
